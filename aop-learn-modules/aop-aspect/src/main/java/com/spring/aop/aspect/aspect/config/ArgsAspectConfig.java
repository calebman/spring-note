package com.spring.aop.aspect.aspect.config;

import com.spring.aop.aspect.aspect.advice.BaseAdviceConfig;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 使用参数方式匹配切面的用法
 */
@Aspect
@Component
public class ArgsAspectConfig extends BaseAdviceConfig {

    @Pointcut("args(String,String) && within(com.spring.aop.aspect.service.args.*)")
//    @Pointcut("args(long) && within(com.spring.aop.aspect.service.args.*)")
//    @Pointcut("args(long,..) && within(com.spring.aop.aspect.service.args.*)")
//    @Pointcut("args() && within(com.spring.aop.aspect.service.args.*)")
    @Override
    public void match() {
    }
}
