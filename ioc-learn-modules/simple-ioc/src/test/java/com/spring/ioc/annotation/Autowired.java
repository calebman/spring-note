package com.spring.ioc.annotation;

import java.lang.annotation.*;

/**
 * @author calebman
 * @date 2018/8/23
 * @description
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Autowired {

}
