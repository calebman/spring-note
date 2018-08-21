package com.spring.ioc.autowired;

import org.springframework.stereotype.Component;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Component
public class MysqlManager extends AbstractDatabaseManager {
    @Override
    public String getUrl() {
        return "jdbc:mysql://localhost:3306/test?user=root&password=root";
    }
}
