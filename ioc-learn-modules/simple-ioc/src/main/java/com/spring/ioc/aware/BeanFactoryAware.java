package com.spring.ioc.aware;

import com.spring.ioc.context.BeanFactory;

/**
 * @author calebman
 * @date 2018/8/23
 * @description
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory factory);
}
