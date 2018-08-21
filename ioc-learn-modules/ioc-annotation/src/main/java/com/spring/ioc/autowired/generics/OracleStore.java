package com.spring.ioc.autowired.generics;

import com.spring.ioc.autowired.OracleManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class OracleStore implements JdbcStore<OracleManager> {

    @Autowired
    OracleManager manager;


    @Override
    public void generatorAdmin() {
        manager.executeSql("insert into admin(username,password) value('admin','admin')");
    }
}
