package com.spring.aop.action.service;

import com.spring.aop.action.annotation.RequirePermission;
import com.spring.aop.action.dao.UserDao;
import com.spring.aop.action.exception.AuthException;
import com.spring.aop.action.pojo.User;
import com.spring.aop.action.security.CurrentUser;
import com.spring.aop.action.security.CurrentUserHolder;
import com.spring.aop.action.security.Permission;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/18
 * @description 用户操作服务
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 添加一个用户
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequirePermission(Permission.ADMIN)
    public void saveUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPermission(Permission.NORMAL.toString());
        user.setRealname("普通用户");
        user.setState(1);
        userDao.save(user);
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     */
    public void login(String username, String password) {
        log.info("用户名为{}的用户进行登录", username);
        User user = userDao.findUserByUsernameAndPassword(username, password);
        if (user == null) {
            throw new AuthException("用户名或者密码错误");
        }
        log.info("登录成功,user = {}", user);
        CurrentUserHolder.generatorUser(user);
    }
}
