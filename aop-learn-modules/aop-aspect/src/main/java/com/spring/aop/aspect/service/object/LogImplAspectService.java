package com.spring.aop.aspect.service.object;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 使用对象进行切面的服务类
 */
@Service
public class LogImplAspectService implements Loggable {
    Logger log = LoggerFactory.getLogger(LogImplAspectService.class);

    @Override
    public void callLog() {
        log.info("callLog");
    }
}
