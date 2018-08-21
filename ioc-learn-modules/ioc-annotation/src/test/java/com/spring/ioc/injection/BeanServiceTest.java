package com.spring.ioc.injection;

import com.spring.ioc.SpringBaseTest;
import com.spring.ioc.injection.BeanService;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class BeanServiceTest extends SpringBaseTest {

    public BeanServiceTest() {
        super("classpath*:spring-bean-annotation.xml");
    }

    @Test
    public void addTest() {
        getContext().getBean("beanService", BeanService.class).add();
    }
}
