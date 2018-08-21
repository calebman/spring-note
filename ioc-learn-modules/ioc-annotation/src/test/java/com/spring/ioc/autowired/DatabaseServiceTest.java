package com.spring.ioc.autowired;

import com.spring.ioc.SpringBaseTest;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class DatabaseServiceTest extends SpringBaseTest {

    public DatabaseServiceTest() {
        super("classpath*:spring-bean-annotation.xml");
    }

    @Test
    public void showDatabaseManagerBeanListTest() {
        getContext().getBean("databaseService", DatabaseService.class).showDatabaseManagerBeanList();
    }

    @Test
    public void showDatabaseManagerBeanMapTest() {
        getContext().getBean("databaseService", DatabaseService.class).showDatabaseManagerBeanMap();
    }

    @Test
    public void showDatabaseManagerBeanSetTest() {
        getContext().getBean("databaseService", DatabaseService.class).showDatabaseManagerBeanSet();
    }
}
