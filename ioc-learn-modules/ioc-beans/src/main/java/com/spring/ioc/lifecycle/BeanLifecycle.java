package com.spring.ioc.lifecycle;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanLifecycle implements BeanLifecycleInterface, InitializingBean, DisposableBean, BeanNameAware {

    private String arg;

    public void setArg(String arg) {
        this.arg = arg;
        System.out.println("injection arg " + arg);
    }

    public BeanLifecycle() {
        System.out.println("instantiation");
    }

    @Override
    public void say() {
        System.out.println("say");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init");
    }

    public void init() {
        System.out.println("init-method");
    }

    public void destory() {
        System.out.println("destory-method");
    }

    public void defaultInit() {
        System.out.println("default-init-method");
    }

    public void defaultDestory() {
        System.out.println("default-destory-method");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware " + s);
    }
}
