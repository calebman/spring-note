package com.spring.aop.aspect.annotation;

import java.lang.annotation.*;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 类级别的切面注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
public @interface AspectClass {
}
