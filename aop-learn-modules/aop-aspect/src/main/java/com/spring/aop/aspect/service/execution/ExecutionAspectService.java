package com.spring.aop.aspect.service.execution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/15
 * @description execution表达式进行切面的服务类
 */
@Service
public class ExecutionAspectService {
    Logger logger = LoggerFactory.getLogger(ExecutionAspectService.class);

    public void insert(String name) {
        logger.info("insert " + name);
    }

    public String findById(long id) {
        logger.info("findById " + id);
        return "get id " + id;
    }

    public void deleteAll() {
        logger.info("deleteAll");
    }

    public void allException() throws Exception {
        logger.info("allException");
        throw new Exception("allException");
    }

    public void runntimeException() {
        logger.info("runntimeException");
        throw new RuntimeException("runntimeException");
    }
}
