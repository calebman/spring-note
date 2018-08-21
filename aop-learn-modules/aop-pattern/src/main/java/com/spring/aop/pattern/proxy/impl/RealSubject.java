package com.spring.aop.pattern.proxy.impl;

import com.spring.aop.pattern.proxy.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 被代理接口的实现类
 */
public class RealSubject implements Subject {
    Logger logger = LoggerFactory.getLogger(RealSubject.class);

    @Override
    public void request() {
        logger.info("do request");
    }
}
