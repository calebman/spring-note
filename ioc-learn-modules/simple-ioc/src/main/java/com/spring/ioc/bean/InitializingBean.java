package com.spring.ioc.bean;

/**
 * @author calebman
 * @date 2018/8/23
 * @description
 */
public interface InitializingBean {
    void afterPropertiesSet();
}
