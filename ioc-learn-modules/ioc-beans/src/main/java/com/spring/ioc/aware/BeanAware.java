package com.spring.ioc.aware;

import com.spring.ioc.scope.BeanScopeInterface;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanAware implements BeanAwareInterface, ApplicationContextAware, BeanNameAware {
    private String beanName;
    private ApplicationContext context;

    @Override
    public void say() {
        System.out.println("BeanAware default bean name is " + beanName);
        context.getBean(BeanScopeInterface.class).say();
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
