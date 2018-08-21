package com.spring.aop.aspect.aspect.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 通知抽象类
 */
public abstract class BaseAdviceConfig implements BeanNameAware {

    public abstract void match();

    protected Logger logger = LoggerFactory.getLogger(BaseAdviceConfig.class);

    @Override
    public void setBeanName(String var1) {
        logger = LoggerFactory.getLogger(var1);
    }

    @Before("match()")
    public void beforeAdvice() {
        logger.info("[前置通知 beforeAdvice]");
    }

    @After("match()")
    public void afterAdvice() {
        logger.info("[后置通知 afterAdvice]");
    }

    @AfterReturning(value = "match()", returning = "result")
    public void afterReurningAdvice(Object result) {
        logger.info("[返回通知 afterReurningAdvice result = " + result + "]");
    }

    @AfterThrowing("match()")
    public void afterThrowingAdvice() {
        logger.info("[异常通知 afterThrowingAdvice]");
    }

    @Around("match()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("[环绕通知——函数执行前 around before]");
        Object result = null;
        try {
            result = joinPoint.proceed(joinPoint.getArgs());
            logger.info("[环绕通知——函数执行结果 around after returning result = " + result + "]");
        } catch (Throwable throwable) {
            logger.info("[环绕通知——函数抛出异常 around after throwing]");
            throwable.printStackTrace();
            // throw
            throw throwable;
        } finally {
            logger.info("[环绕通知——函数执行后 around after]");
        }
        return result;
    }
}
