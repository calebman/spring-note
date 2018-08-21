package com.spring.ioc.autowiring;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanDao {

    public void save(String name) {
        System.out.println("BeanDao save " + name);
    }
}
