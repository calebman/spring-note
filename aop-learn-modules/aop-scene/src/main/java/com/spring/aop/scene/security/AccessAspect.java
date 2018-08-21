package com.spring.aop.scene.security;

import com.spring.aop.scene.service.AuthService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 权限校验切面类
 */
@Aspect
@Component
public class AccessAspect {

    @Autowired
    AuthService authService;

    @Pointcut("@annotation(com.spring.aop.scene.annotation.AdminOnly)")
    public void adminOnly() {

    }

    @Before("adminOnly()")
    public void checkAccess() {
        authService.checkAccess();
    }
}
