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

import java.util.*;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 对服务层的参数脱敏切面
 */
@Aspect
@Component
@Slf4j
public class DesensitizationAspect {

    static final String[] SENSITIVE_ARR = new String[]{"yellow", "silly", "fool", "stupid"};

    @Autowired
    RedisTemplate redisTemplate;

    @Around(value = "within(com.spring.aop.action.service.*)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = ((MethodSignature) joinPoint.getSignature()).getMethod().getName();
        Object[] args = joinPoint.getArgs();
        showInvokeMethodInfo(className, methodName, args);
        if (args.length > 0) {
            List<Integer> desArgPosList = new ArrayList<>();
            Set<String> senstiveset = new HashSet<>();
            // 获取敏感词信息及其敏感参数位置信息
            for (int i = 0; i < args.length; i++) {
                List<String> senstives = DesensitizationUtil.getSensitivesOfObj(args[i], SENSITIVE_ARR);
                if (senstives.size() > 0) {
                    desArgPosList.add(i);
                    senstiveset.addAll(senstives);
                }
            }
            if (desArgPosList.size() > 0) {
                // 将敏感调用存储在redis中
                // 构建存储实体
                DesensitizationInvokeInfo desensitizationInvokeInfo = new DesensitizationInvokeInfo();
                desensitizationInvokeInfo.setCurrentUsername(CurrentUserHolder.getCurrentUser() == null ? null : CurrentUserHolder.getCurrentUser().getUser().getUsername());
                desensitizationInvokeInfo.setClassName(className);
                desensitizationInvokeInfo.setMethodName(methodName);
                desensitizationInvokeInfo.setArgs(copy(args, desArgPosList));
                desensitizationInvokeInfo.setSensitives(senstiveset);
                // 脱敏处理
                desensitizationArgs(args, desArgPosList);
                desensitizationInvokeInfo.setDesensitizationArgs(copy(args, desArgPosList));
                // 存储在redis中
                ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
                String key = UUID.randomUUID().toString().replaceAll("-", "");
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
     * @param args          源数组
     * @param desArgPosList 复制位置
     * @return 目标数组
     */
    List<Object> copy(Object[] args, List<Integer> desArgPosList) {
        List<Object> ret = new ArrayList<>();
        for (int pos : desArgPosList) {
            ret.add(args[pos]);
        }
        return ret;
    }

    /**
     * 敏感参数脱敏
     *
     * @param args 方法参数
     */
    void desensitizationArgs(Object[] args, List<Integer> desArgPosList) {
        log.info("####进行参数脱敏####");
        for (int pos : desArgPosList) {
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
