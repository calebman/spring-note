package com.spring.aop.pattern.chain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 测试责任链模式的后置者实现
 */
public class HandlerTest {
    static final Logger logger = LoggerFactory.getLogger(HandlerTest.class);

    static class HandlerA extends Handler {
        @Override
        protected void handleProcess() {
            logger.info("handler by HandlerA");
        }
    }

    static class HandlerB extends Handler {
        @Override
        protected void handleProcess() {
            logger.info("handler by HandlerB");
        }
    }

    static class HandlerC extends Handler {
        @Override
        protected void handleProcess() {
            logger.info("handler by HandlerC");
        }
    }

    @Test
    public void testHandler() {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();

        handlerA.setSucessor(handlerB);
        handlerB.setSucessor(handlerC);

        handlerA.execute();
    }
}
