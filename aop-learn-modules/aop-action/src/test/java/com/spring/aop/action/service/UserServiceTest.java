package com.spring.aop.action.service;

import com.spring.aop.action.exception.AuthException;
import com.spring.aop.action.security.CurrentUserHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author calebman
 * @date 2018/8/18
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void saveUserTest() {
        CurrentUserHolder.generatorAdmin();
        userService.saveUser("normal", "normal");
    }

    @Test
    public void loginTest() {
        try {
            userService.login("normalsb", "normal");
        } catch (AuthException ex) {
            ex.printStackTrace();
        }
        userService.login("normal", "normal");
    }
}
