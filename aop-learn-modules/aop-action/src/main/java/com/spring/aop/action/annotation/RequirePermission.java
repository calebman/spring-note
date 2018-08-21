package com.spring.aop.action.annotation;

import com.spring.aop.action.security.Permission;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 权限访问
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface RequirePermission {
    Permission[] value() default {};
}
