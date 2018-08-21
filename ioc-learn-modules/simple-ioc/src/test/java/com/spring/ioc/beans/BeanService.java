package com.spring.ioc.beans;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanService {

    private BeanDao beanDao;

    public void setBeanDao(BeanDao beanDao) {
        this.beanDao = beanDao;
    }

    public void say() {
        System.out.println("BeanService say hello");
        beanDao.say();
    }
}
