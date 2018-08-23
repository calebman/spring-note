package com.spring.ioc.context;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public interface BeanFactory {
    /**
     * 从IOC容器中获取一个实体类
     *
     * @param name 实体类的ID
     * @return 实体类对象
     */
    Object getBean(String name);

    /**
     * 从IOC容器中获取一个实体类
     *
     * @param type 类型
     * @return 实体类对象
     */
    Object getBean(Class<?> type);

    /**
     * 关闭容器
     */
    void close() throws Exception;
}
