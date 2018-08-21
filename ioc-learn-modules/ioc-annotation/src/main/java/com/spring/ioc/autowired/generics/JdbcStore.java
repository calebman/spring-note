package com.spring.ioc.autowired.generics;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public interface JdbcStore<T> {

    /**
     * 生成一个管理员
     */
    void generatorAdmin();
}
