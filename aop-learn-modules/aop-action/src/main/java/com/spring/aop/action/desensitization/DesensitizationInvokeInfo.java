package com.spring.aop.action.desensitization;

import com.spring.aop.action.pojo.User;
import com.spring.aop.action.security.CurrentUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @author calebman
 * @date 2018/8/19
 * @description
 */
@Data
public class DesensitizationInvokeInfo {
    // 当前操作用户
    private CurrentUser currentUser;
    // 调用服务类
    private String className;
    // 调用服务方法
    private String methodName;
    // 服务参数
    private Object[] args;
    // 脱敏后的参数
    private Object[] desensitizationArgs;
}
