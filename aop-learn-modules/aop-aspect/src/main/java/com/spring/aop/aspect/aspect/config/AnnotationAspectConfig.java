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
 * @description 使用注解方式匹配切面的用法
 * 注解匹配
 * 方法、参数、类三种级别
 */
@Aspect
@Component
public class AnnotationAspectConfig extends BaseAdviceConfig {

    @Pointcut("@within(com.spring.aop.aspect.annotation.AspectClass)")
//    @Pointcut("@target(com.spring.aop.aspect.annotation.AspectClass)")
//    @Pointcut("@args(com.spring.aop.aspect.annotation.AspectArgs)")
    @Override
    public void match() {
    }

}
