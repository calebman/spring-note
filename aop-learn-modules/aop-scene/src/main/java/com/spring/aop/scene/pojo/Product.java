package com.spring.aop.scene.pojo;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 模拟产品实体
 */
public class Product {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
