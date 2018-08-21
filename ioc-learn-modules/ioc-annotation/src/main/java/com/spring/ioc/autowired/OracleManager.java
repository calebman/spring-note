package com.spring.ioc.autowired;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Component
//@Order(1)
public class OracleManager extends AbstractDatabaseManager {
    @Override
    public String getUrl() {
        return "jdbc:oracle:thin:@localhost:1521: test";
    }
}
