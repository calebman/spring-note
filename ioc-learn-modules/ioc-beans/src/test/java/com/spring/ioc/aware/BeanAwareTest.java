package com.spring.ioc.aware;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanAwareTest extends SpringBaseTest {

    public BeanAwareTest() {
        super("classpath:spring-aware.xml");
    }

    @Test
    public void awareTest() {
        getContext().getBean(BeanAwareInterface.class).say();
    }
}
