package com.spring.ioc.book;

/**
 * @author calebman
 * @date 2018/9/5
 * @description
 */
public class Book implements BookInterface {
    private String name;
    private Double price;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }
}
