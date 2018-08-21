package com.spring.aop.scene.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 只允许admin用户访问权限的注解
 * @see com.spring.aop.scene.security.AccessAspect
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AdminOnly {

}
