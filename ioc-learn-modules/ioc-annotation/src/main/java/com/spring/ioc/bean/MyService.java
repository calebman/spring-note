package com.spring.ioc.bean;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class MyService {

    public void say() {
        System.out.println("MyService say hello");
    }

    public void init(){
        System.out.println("MyService init");
    }

    public void destory(){
        System.out.println("MyService destory");
    }
}
