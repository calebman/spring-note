package com.spring.ioc.injection;

import org.springframework.stereotype.Repository;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Repository
public class BeanDao {

    public void save(String arg) {
        System.out.println("BeanDao save " + arg);
    }
}
