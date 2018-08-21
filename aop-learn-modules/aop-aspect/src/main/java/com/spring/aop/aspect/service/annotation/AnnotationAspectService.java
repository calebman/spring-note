package com.spring.aop.aspect.service.annotation;

import com.spring.aop.aspect.annotation.AspectArgs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 使用注解进行切面的服务类
 */
@Service
public class AnnotationAspectService extends BaseAnnotationAspectService {
    Logger log = LoggerFactory.getLogger(AnnotationAspectService.class);

    public void doBussiness() {
        log.info("doBussiness");
    }

    public void doArgs(@AspectArgs String arg) {
        log.info("arg = " + arg);
    }
}
