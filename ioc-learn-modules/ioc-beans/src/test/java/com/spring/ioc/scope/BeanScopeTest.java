package com.spring.ioc.scope;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanScopeTest extends SpringBaseTest {

    public BeanScopeTest() {
        super("classpath:spring-scope.xml");
    }

    @Test
    public void singletionTest() {
        BeanScopeInterface beanScope = getContext().getBean("singletionBeanScope", BeanScopeInterface.class);
        beanScope.say();
        beanScope = getContext().getBean("singletionBeanScope", BeanScopeInterface.class);
        beanScope.say();
    }

    @Test
    public void prototypeTest() {
        BeanScopeInterface beanScope = getContext().getBean("prototypeBeanScope", BeanScopeInterface.class);
        beanScope.say();
        beanScope = getContext().getBean("prototypeBeanScope", BeanScopeInterface.class);
        beanScope.say();
    }
}