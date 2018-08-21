package com.spring.ioc.value;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanJdbcValueTest extends SpringBaseTest {
    public BeanJdbcValueTest() {
        super("classpath*:spring-properties.xml");
    }

    @Test
    public void valueTest() {
        BeanJdbcValue beanJdbcValue = getContext().getBean("beanJdbcValue", BeanJdbcValue.class);
        System.out.println("jdbc.username = " + beanJdbcValue.getUsername());
        System.out.println("jdbc.password = " + beanJdbcValue.getPassword());
    }
}
