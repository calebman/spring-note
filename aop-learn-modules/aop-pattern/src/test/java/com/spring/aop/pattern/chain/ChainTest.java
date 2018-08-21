package com.spring.aop.pattern.chain;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 测试责任链模式的管道实现
 */
public class ChainTest {
    static final Logger logger = LoggerFactory.getLogger(ChainTest.class);

    static class ChainHandlerA extends ChainHandler {
        @Override
        protected void handleProcess() {
            logger.info("handler by ChainHandlerA");
        }
    }

    static class ChainHandlerB extends ChainHandler {
        @Override
        protected void handleProcess() {
            logger.info("handler by ChainHandlerB");
        }
    }

    static class ChainHandlerC extends ChainHandler {
        @Override
        protected void handleProcess() {
            logger.info("handler by ChainHandlerC");
        }
    }

    @Test
    public void testChain() {
        List<ChainHandler> handlerList = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );
        Chain chain = new Chain(handlerList);
        chain.proceed();
    }
}
