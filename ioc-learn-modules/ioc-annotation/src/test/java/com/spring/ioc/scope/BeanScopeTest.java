package com.spring.ioc.scope;

import com.spring.ioc.SpringBaseTest;
import com.spring.ioc.scope.BeanScope;
import org.junit.Test;

public class BeanScopeTest extends SpringBaseTest {

    public BeanScopeTest() {
        super("classpath*:spring-bean-annotation.xml");
    }

    @Test
    public void testSay() {
        BeanScope beanScope = getContext().getBean("beanAnnotation", BeanScope.class);
        beanScope.say();
        beanScope = getContext().getBean("beanAnnotation", BeanScope.class);
        beanScope.say();
    }

}
