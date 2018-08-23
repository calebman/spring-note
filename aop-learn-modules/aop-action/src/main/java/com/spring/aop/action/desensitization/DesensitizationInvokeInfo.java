package com.spring.aop.action.desensitization;

import com.spring.aop.action.pojo.User;
import com.spring.aop.action.security.CurrentUser;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author calebman
 * @date 2018/8/19
 * @description
 */
@Data
public class DesensitizationInvokeInfo {
    // 当前操作用户
    private String currentUsername;
    // 调用服务类
    private String className;
    // 调用服务方法
    private String methodName;
    // 检测参数
    private List<Object> args;
    // 脱敏后的参数
    private List<Object> desensitizationArgs;
    // 涉及敏感词
    private Set<String> sensitives;
}
