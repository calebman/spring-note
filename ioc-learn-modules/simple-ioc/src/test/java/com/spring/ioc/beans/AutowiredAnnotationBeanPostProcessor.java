package com.spring.ioc.beans;

import com.spring.ioc.annotation.Autowired;
import com.spring.ioc.aware.BeanFactoryAware;
import com.spring.ioc.context.BeanFactory;
import com.spring.ioc.processor.BeanPostProcessor;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * @author calebman
 * @date 2018/8/23
 * @description
 */
public class AutowiredAnnotationBeanPostProcessor implements BeanPostProcessor, BeanFactoryAware {

    private BeanFactory factory;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String name) throws IllegalAccessException {
        System.out.println(name + " postProcessBeforeInitialization");
        // 判断字段中是否包含Aotowired注解
        List<Field> fieldList = Arrays.asList(bean.getClass().getDeclaredFields());
        for (Field field : fieldList) {
            if (field.isAnnotationPresent(Autowired.class)) {
                Object value = factory.getBean(field.getType());
                field.setAccessible(true);
                field.set(bean, value);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String name) {
        System.out.println(name + " postProcessAfterInitialization");
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory factory) {
        this.factory = factory;
    }
}
