package com.spring.ioc;

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
}
