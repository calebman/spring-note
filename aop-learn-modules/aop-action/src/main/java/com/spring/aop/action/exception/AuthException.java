package com.spring.aop.action.exception;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 认证异常
 */
public class AuthException extends RuntimeException {

    public AuthException(String message) {
        super(message);
    }
}
