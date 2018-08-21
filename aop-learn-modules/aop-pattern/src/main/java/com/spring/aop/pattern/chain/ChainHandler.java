package com.spring.aop.pattern.chain;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 责任链模式
 */
public abstract class ChainHandler {

    public void execute(Chain chain) {
        handleProcess();
        chain.proceed();
    }

    protected abstract void handleProcess();

}
