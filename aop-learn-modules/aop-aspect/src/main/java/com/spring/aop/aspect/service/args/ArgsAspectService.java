package com.spring.aop.aspect.service.args;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 使用参数匹配进行切面的服务类
 */
@Service
public class ArgsAspectService {

    Logger logger = LoggerFactory.getLogger(ArgsAspectService.class);

    public void insertUser(String username, String password) {
        logger.info("insertUser with username = {},password = {}", username, password);
    }

    public void deleteUser(long userId) {
        logger.info("deleteUser with userId = {}", userId);
    }

    public void getAllUser() {
        logger.info("getAllUser");
    }
}
