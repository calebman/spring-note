package com.spring.aop.action.exception;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 敏感词异常
 */
public class SensitiveException extends RuntimeException {

    public SensitiveException(String message) {
        super(message);
    }
}
