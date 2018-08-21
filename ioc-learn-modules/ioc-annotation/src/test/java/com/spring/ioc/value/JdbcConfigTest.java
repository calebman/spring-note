package com.spring.ioc.value;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class JdbcConfigTest extends SpringBaseTest {
    public JdbcConfigTest() {
        super("classpath*:spring-bean-annotation.xml");
    }

    @Test
    public void valueTest() {
        JdbcConfig jdbcConfig = getContext().getBean("jdbcConfig", JdbcConfig.class);
        System.out.println("jdbc.username = " + jdbcConfig.getUsername());
        System.out.println("jdbc.password = " + jdbcConfig.getPassword());
    }
}
