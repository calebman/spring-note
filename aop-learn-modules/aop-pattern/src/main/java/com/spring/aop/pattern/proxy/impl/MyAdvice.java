package com.spring.aop.pattern.proxy.impl;

import com.spring.aop.pattern.proxy.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyAdvice implements Advice {
    Logger logger = LoggerFactory.getLogger(MyAdvice.class);

    @Override
    public void before() {
        logger.info("[前置通知 before]");
    }

    @Override
    public void after() {
        logger.info("[后置通知 after]");
    }

    @Override
    public void afterRetunning() {
        logger.info("[返回通知 afterRetunning]");
    }

    @Override
    public void afterThrowing() {
        logger.info("[异常通知 afterThrowing]");
    }
}
