package com.spring.ioc.autowired.generics;

import com.spring.ioc.autowired.MysqlManager;
import com.spring.ioc.autowired.OracleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Configuration
public class StoreConfig {

    @Autowired
    private JdbcStore<MysqlManager> mysqlStore;

    @Autowired
    private JdbcStore<SqlserverStore> sqlserverStore;

    @Autowired
    private JdbcStore<OracleManager> oracleStore;

    @Autowired
    private List<JdbcStore> jdbcStoreList;

    @Bean
    public JdbcStore mysqlStore() {
        return new MysqlStore();
    }

    @Bean
    public JdbcStore sqlserverStore() {
        return new SqlserverStore();
    }

    @Bean
    public JdbcStore oracleStore() {
        return new OracleStore();
    }

    public void generatorAdmin() {
        mysqlStore.generatorAdmin();
        oracleStore.generatorAdmin();
        sqlserverStore.generatorAdmin();
    }

    public void generatorAdminWithList() {
        for (JdbcStore jdbcStore : jdbcStoreList) {
            jdbcStore.generatorAdmin();
        }
    }
}
