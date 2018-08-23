package com.spring.ioc;

import org.jdom2.Element;

/**
 * @author calebman
 * @date 2018/8/23
 * @description
 */
public class Bean {
    private String id;
    private Object instance;
    private Element config;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getInstance() {
        return instance;
    }

    public void setInstance(Object instance) {
        this.instance = instance;
    }

    public Element getConfig() {
        return config;
    }

    public void setConfig(Element config) {
        this.config = config;
    }
}
