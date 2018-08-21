package com.spring.aop.pattern.chain;

import java.util.List;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 责任链管道
 */
public class Chain {

    private List<ChainHandler> handlerList;

    private int index = 0;

    public Chain(List<ChainHandler> handlerList) {
        this.handlerList = handlerList;
    }

    public void proceed() {
        if (index >= handlerList.size()) {
            return;
        }
        handlerList.get(index++).execute(this);
    }
}
