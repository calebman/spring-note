package com.spring.ioc.autowired;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public abstract class AbstractDatabaseManager implements DatabaseManagerInterface {

    @Override
    public void executeSql(String sql) {
        System.out.println("获取连接 " + getUrl());
        System.out.println("执行脚本 " + sql);
    }

}
