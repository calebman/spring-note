package com.spring.ioc.scope;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanScope implements BeanScopeInterface {
    @Override
    public void say() {
        System.out.println("BeanScope say hashcode is "+this.hashCode());
    }
}
