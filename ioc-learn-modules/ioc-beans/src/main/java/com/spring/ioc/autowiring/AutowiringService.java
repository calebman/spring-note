package com.spring.ioc.autowiring;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class AutowiringService {

    private BeanDao beanDao;

    public void setBeanDao(BeanDao beanDao) {
        this.beanDao = beanDao;
    }

    public void add(String name) {
        System.out.println("BeanService add " + name);
        beanDao.save(name);
    }
}
