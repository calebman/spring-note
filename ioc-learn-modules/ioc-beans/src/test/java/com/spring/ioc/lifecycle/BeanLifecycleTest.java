package com.spring.ioc.lifecycle;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanLifecycleTest extends SpringBaseTest {

    public BeanLifecycleTest() {
        super("classpath:spring-lifecycle.xml");
    }

    @Test
    public void beanLifecycleTest() {
        BeanLifecycleInterface beanLifecycle = getContext().getBean("beanLifecycle", BeanLifecycleInterface.class);
        beanLifecycle.say();
    }

}
