package com.spring.aop.aspect.service.pkg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 使用包进行切面的服务类
 */
@Service
public class PkgTypeAspectService {

    Logger logger = LoggerFactory.getLogger(PkgTypeAspectService.class);

    public void doBussiness() {
        logger.info("doBussiness");
    }
}
