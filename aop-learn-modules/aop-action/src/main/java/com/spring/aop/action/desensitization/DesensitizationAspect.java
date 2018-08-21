package com.spring.aop.action.desensitization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.spring.aop.action.security.CurrentUserHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 对服务层的参数脱敏切面
 */
@Aspect
@Component
@Slf4j
public class DesensitizationAspect {

    static final String[] SENSITIVE_ARR = new String[]{"sb", "2b", "fuck", "hc", "calebman"};

    @Autowired
    RedisTemplate redisTemplate;

    @Around(value = "within(com.spring.aop.action.service.*)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        Object[] args = joinPoint.getArgs();
        showInvokeMethodInfo(className, methodName, args);
        if (args.length > 0) {
            // 获取敏感参数的位置信息
            int[] desArgPos = getDesensitizationArgsLength(args);
            if (desArgPos.length > 0) {
                // 将敏感调用存储在redis中
                // 构建存储实体
                DesensitizationInvokeInfo desensitizationInvokeInfo = new DesensitizationInvokeInfo();
                desensitizationInvokeInfo.setCurrentUser(CurrentUserHolder.getCurrentUser());
                desensitizationInvokeInfo.setClassName(className);
                desensitizationInvokeInfo.setMethodName(methodName);
                desensitizationInvokeInfo.setArgs(copy(args, desArgPos));
                // 脱敏处理
                desensitizationArgs(args, desArgPos);
                desensitizationInvokeInfo.setDesensitizationArgs(copy(args, desArgPos));
                // 存储在redis中
                ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
                String key = "desensitization_obj_" + UUID.randomUUID().toString().replaceAll("-", "");
                String value = new ObjectMapper().writeValueAsString(desensitizationInvokeInfo);
                valueOperations.set(key, value);
                // 显示脱敏后的调用信息
                showInvokeMethodInfo(className, methodName, args);
            }
        }
        return joinPoint.proceed(joinPoint.getArgs());
    }

    /**
     * 复制数组
     *
     * @param args 源数组
     * @param pos  复制位置
     * @return 目标数组
     */
    Object[] copy(Object[] args, int[] pos) {
        Object[] ret = new Object[pos.length];
        for (int i = 0; i < pos.length; i++) {
            ret[i] = args[pos[i]];
        }
        return ret;
    }

    /**
     * 获取敏感参数长度
     *
     * @param args 参数列表
     * @return 敏感参数长度
     */
    int[] getDesensitizationArgsLength(Object[] args) {
        List<Integer> desArgPosList = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            if (DesensitizationUtil.hasSensitive(args[i], SENSITIVE_ARR)) {
                desArgPosList.add(i);
            }
        }
        int[] desArgPos = new int[desArgPosList.size()];
        for (int i = 0; i < desArgPosList.size(); i++) {
            desArgPos[i] = desArgPosList.get(i);
        }
        return desArgPos;
    }

    /**
     * 敏感参数脱敏
     *
     * @param args 方法参数
     */
    void desensitizationArgs(Object[] args, int[] desArgPos) {
        log.info("####进行参数脱敏####");
        for (int pos : desArgPos) {
            args[pos] = DesensitizationUtil.desensitization(args[pos], SENSITIVE_ARR);
        }
    }

    /**
     * 显示调用信息
     *
     * @param className  方法所在类名称
     * @param methodName 方法名称
     * @param args       方法参数
     */
    void showInvokeMethodInfo(String className, String methodName, Object[] args) {
        String format = "####服务层调用{}.{}(";
        if (args.length > 0) {
            for (Object arg : args) {
                format += arg.toString() + ",";
            }
            format = format.substring(0, format.length() - 1);
        }
        format += ")####";

        log.info(format, className, methodName);
    }
}
