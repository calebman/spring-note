package com.spring.ioc;

import org.junit.After;
import org.junit.Before;
import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StringUtils;

public class SpringBaseTest {

    private ClassPathXmlApplicationContext context;

    private String springXmlpath;

    public SpringBaseTest() {
    }

    public SpringBaseTest(String springXmlpath) {
        this.springXmlpath = springXmlpath;
    }

    @Before
    public void before() {
        if (StringUtils.isEmpty(springXmlpath)) {
            springXmlpath = "classpath*:spring-*.xml";
        }
        try {
            context = new ClassPathXmlApplicationContext(springXmlpath.split("[,\\s]+"));
            context.start();
        } catch (BeansException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        context.destroy();
    }

    public ClassPathXmlApplicationContext getContext() {
        return context;
    }
}
