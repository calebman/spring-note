package com.spring.ioc.bean;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class MyServiceTest extends SpringBaseTest {

    public MyServiceTest() {
        super("classpath*:spring-bean-annotation.xml");
    }

    @Test
    public void myServiceTest() {
        getContext().getBean("myService", MyService.class).say();
    }
}
