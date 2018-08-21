package com.spring.ioc.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class LifecycleBeanPostPorcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("LifecycleBeanPostPorcessor before " + s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("LifecycleBeanPostPorcessor after " + s);
        return o;
    }
}
