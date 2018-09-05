package com.spring.ioc.book;

/**
 * @author calebman
 * @date 2018/9/5
 * @description
 */
public interface BookInterface {
    // 获取书的名称
    String getName();

    void setName(String name);

    // 获取书的价格
    Double getPrice();

    void setPrice(Double price);
}