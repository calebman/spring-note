package com.spring.aop.action.security;

import com.spring.aop.action.annotation.RequirePermission;
import com.spring.aop.action.exception.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 权限校验切面类
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class SecurityAspect {

    @Pointcut("@within(com.spring.aop.action.annotation.RequirePermission)")
    public void requirePermission() {

    }

    @Around("requirePermission()")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前用户信息
        CurrentUser currentUser = CurrentUserHolder.getCurrentUser();
        String[] userRoles = currentUser == null ? new String[]{} : currentUser.getRoles();
        // 获取必要权限信息
        Permission[] permissions = getNeedPermission(joinPoint);
        // 匹配权限
        if (matchPermission(userRoles, permissions)) {
            log.info("有权访问");
            return joinPoint.proceed(joinPoint.getArgs());
        } else {
            throw new AuthException("权限不足");
        }
    }

    /**
     * 获取调用方法的必要权限信息
     *
     * @param pj
     * @return
     */
    private Permission[] getNeedPermission(ProceedingJoinPoint pj) {
        // 获取切入的 Method
        MethodSignature joinPointObject = (MethodSignature) pj.getSignature();
        Method method = joinPointObject.getMethod();
        boolean flag = method.isAnnotationPresent(RequirePermission.class);
        if (flag) {
            RequirePermission annotation = method.getAnnotation(RequirePermission.class);
            return annotation.value();
        } else {
            // 如果方法上没有注解，则搜索类上是否有注解
            RequirePermission classAnnotation = AnnotationUtils.findAnnotation(joinPointObject.getMethod().getDeclaringClass(), RequirePermission.class);
            if (classAnnotation != null) {
                return classAnnotation.value();
            } else {
                return new Permission[]{};
            }
        }
    }

    /**
     * 匹配权限
     *
     * @param userRoles      用户权限列表
     * @param hasPermissions 需要权限列表之一
     * @return 是否有权限访问
     */
    boolean matchPermission(String[] userRoles, Permission[] hasPermissions) {
        log.info("匹配权限user roles {} need take one of items {}", userRoles, hasPermissions);
        for (Permission permission : hasPermissions) {
            for (String role : userRoles) {
                if (permission.toString().equals(role)) {
                    return true;
                }
            }
        }
        return false;
    }
}
