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
 * @description 使用对象匹配切面的用法
 */
@Aspect
@Component
public class ObjectAspectConfig extends BaseAdviceConfig {

    @Pointcut("this(com.spring.aop.aspect.service.object.Loggable)")
//    @Pointcut("target(com.spring.aop.aspect.service.object.Loggable)")
//    @Pointcut("bean(logService)")
    @Override
    public void match() {
    }
}
