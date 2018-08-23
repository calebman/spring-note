package com.spring.ioc.processor;

/**
 * @author calebman
 * @date 2018/8/23
 * @description
 */
public interface BeanPostProcessor {
    Object postProcessBeforeInitialization(Object bean, String name) throws Exception;

    Object postProcessAfterInitialization(Object bean, String name) throws Exception;
}
