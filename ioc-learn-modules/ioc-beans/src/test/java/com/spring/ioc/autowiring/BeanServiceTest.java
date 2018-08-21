package com.spring.ioc.autowiring;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanServiceTest extends SpringBaseTest {
    public BeanServiceTest() {
        super("classpath:spring-autowiring.xml");
    }

    @Test
    public void addTest() {
        AutowiringService autowiringService = getContext().getBean("autowiringService", AutowiringService.class);
        autowiringService.add("123");
    }
}
