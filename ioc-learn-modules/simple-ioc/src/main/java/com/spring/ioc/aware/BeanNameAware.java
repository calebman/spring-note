package com.spring.ioc.aware;

/**
 * @author calebman
 * @date 2018/8/23
 * @description
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
