package com.spring.ioc.beans;

import com.spring.ioc.annotation.Autowired;
import com.spring.ioc.aware.BeanFactoryAware;
import com.spring.ioc.aware.BeanNameAware;
import com.spring.ioc.bean.DisposableBean;
import com.spring.ioc.bean.InitializingBean;
import com.spring.ioc.context.BeanFactory;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanService implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware {



    private String serviceName;

    public BeanService(String serviceName) {
        System.out.println("constructor arg " + serviceName);
        this.serviceName = serviceName;
    }

    @Autowired
    private BeanDao beanDao;

    public void setBeanDao(BeanDao beanDao) {
        System.out.println("setter arg");
        this.beanDao = beanDao;
    }

    public void say() {
        System.out.println("BeanService say hello");
        beanDao.say();
    }

    @Override
    public void setBeanFactory(BeanFactory factory) {
        System.out.println("BeanFactoryAware");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("BeanNameAware");
    }

    @Override
    public void destroy() {
        System.out.println("DisposableBean");
    }

    @Override
    public void afterPropertiesSet() {
        System.out.println("InitializingBean");
    }

    public void customInit() {
        System.out.println("init-method");
    }

    public void customDestory() {
        System.out.println("destory-method");
    }
}
