package com.spring.aop.pattern.proxy;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 通知接口
 */
public interface Advice {

    /**
     * 前置通知
     */
    void before();

    /**
     * 后置通知
     */
    void after();

    /**
     * 返回通知
     */
    void afterRetunning();

    /**
     * 异常通知
     */
    void afterThrowing();
}
