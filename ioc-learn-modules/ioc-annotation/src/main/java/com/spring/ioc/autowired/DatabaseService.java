package com.spring.ioc.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Service
public class DatabaseService {

    @Autowired
    private ApplicationContext context;

    // 默认以类型装载，此处会报错
//    @Autowired
    private DatabaseManagerInterface databaseManager;

    @Autowired
    private List<DatabaseManagerInterface> databaseManagerInterfaceList;

    @Autowired
    private Map<String, DatabaseManagerInterface> databaseManagerInterfaceMap;

    @Autowired
    private Set<DatabaseManagerInterface> databaseManagerInterfaceSet;


    public void showDatabaseManagerBeanList() {
        for (DatabaseManagerInterface databaseManager : databaseManagerInterfaceList) {
            System.out.println(databaseManager.getUrl());
        }
    }

    public void showDatabaseManagerBeanMap() {
        for (Map.Entry<String, DatabaseManagerInterface> entry : databaseManagerInterfaceMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().getUrl());
        }
    }

    public void showDatabaseManagerBeanSet() {
        for (DatabaseManagerInterface databaseManager : databaseManagerInterfaceSet) {
            System.out.println(databaseManager.getUrl());
        }
    }
}
