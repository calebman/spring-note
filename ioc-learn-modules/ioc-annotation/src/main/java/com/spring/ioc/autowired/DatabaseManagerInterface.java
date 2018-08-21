package com.spring.ioc.autowired;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public interface DatabaseManagerInterface {
    /**
     * 数据库连接url
     */
    String getUrl();

    /**
     * 执行sql脚本
     *
     * @param sql 脚本
     */
    void executeSql(String sql);
}
