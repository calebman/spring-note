package com.spring.ioc.autowired;

import org.springframework.stereotype.Component;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Component
public class SqlserverManager extends AbstractDatabaseManager {
    @Override
    public String getUrl() {
        return "jdbc:microsoft:sqlserver://localhost:1433:Databasename=test";
    }
}
