package com.spring.ioc;

import com.spring.ioc.beans.BeanService;
import org.jdom2.JDOMException;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanTest {

    @Test
    public void beanTest() throws IllegalAccessException, InvocationTargetException, IOException, InstantiationException, JDOMException, NoSuchMethodException, ClassNotFoundException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext();
        BeanService beanService = (BeanService) beanFactory.getBean("beanService");
        beanService.say();
    }
}
