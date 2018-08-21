package com.spring.ioc.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Service
public class BeanService {

    @Autowired
    private BeanDao beanDao;

//    @Autowired
//    @Required
    public void setBeanDao(BeanDao beanDao) {
        this.beanDao = beanDao;
    }

    public void add() {
        System.out.println("BeanService add ");
        beanDao.save("123");
    }
}
