package com.spring.ioc.autowired;

import com.spring.ioc.SpringBaseTest;
import com.spring.ioc.autowired.generics.StoreConfig;
import org.junit.Test;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class JdbcStoreTest extends SpringBaseTest {
    public JdbcStoreTest() {
        super("classpath*:spring-bean-annotation.xml");
    }

    @Test
    public void storeTest() {
        StoreConfig storeConfig = getContext().getBean("storeConfig", StoreConfig.class);
        storeConfig.generatorAdmin();
    }

    @Test
    public void storeListTest() {
        StoreConfig storeConfig = getContext().getBean("storeConfig", StoreConfig.class);
        storeConfig.generatorAdminWithList();
    }
}
