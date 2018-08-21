package com.spring.aop.action.security;

import com.spring.aop.action.pojo.User;
import lombok.Data;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author calebman
 * @date 2018/8/17
 * @description 当前操作用户实体
 */
@Data
public class CurrentUser {
    // 用户信息
    private User user;
    // 权限列表
    private String[] roles;
}
