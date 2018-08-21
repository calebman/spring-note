package com.spring.aop.scene.service;

import com.spring.aop.scene.security.CurrentUserHolder;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 权限校验服务
 */
@Service
public class AuthService {

    /**
     * 权限校验
     */
    public void checkAccess() {
        String username = CurrentUserHolder.get();
        if (!"admin".equals(username)) {
            throw new RuntimeException("operation not allow");
        }
    }
}
