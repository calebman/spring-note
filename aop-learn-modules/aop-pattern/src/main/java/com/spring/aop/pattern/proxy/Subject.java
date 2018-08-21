package com.spring.aop.pattern.proxy;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 代理模式下需要被代理的接口
 */
public interface Subject {
    /**
     * 发起一个业务请求
     */
    void request();
}
