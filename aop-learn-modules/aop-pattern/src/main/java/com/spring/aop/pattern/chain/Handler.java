package com.spring.aop.pattern.chain;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 责任链模式
 */
public abstract class Handler {
    private Handler sucessor;

    public Handler getSucessor() {
        return sucessor;
    }

    public void setSucessor(Handler sucessor) {
        this.sucessor = sucessor;
    }

    public void execute() {
        handleProcess();
        if (getSucessor() != null) {
            getSucessor().execute();
        }
    }

    protected abstract void handleProcess();
}
