package com.spring.ioc;

import com.spring.ioc.beans.BeanService;
import com.spring.ioc.context.BeanFactory;
import org.jdom2.JDOMException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanTest {

    BeanFactory beanFactory = null;

    @Before
    public void before() throws Exception {
        beanFactory = new ClassPathXmlApplicationContext();
    }

    @Test
    public void beanTest() {
        BeanService beanService = (BeanService) beanFactory.getBean("beanService");
        beanService.say();
    }

    @After
    public void after() throws Exception {
        beanFactory.close();
    }
}
