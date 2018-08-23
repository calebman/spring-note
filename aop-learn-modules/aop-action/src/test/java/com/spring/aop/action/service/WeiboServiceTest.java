package com.spring.aop.action.service;

import com.github.javafaker.Faker;
import com.spring.aop.action.pojo.Weibo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * @author calebman
 * @date 2018/8/18
 * @description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeiboServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    WeiboService weiboService;

    @Before
    public void login() {
        userService.login("normal", "normal");
    }

    @Test
    public void weiboTest() {
        Faker faker = new Faker();
        for (int i = 1; i <= 50; i++) {
            String weiboTitle = faker.lorem().sentence();
            String weiboContent = faker.lorem().paragraph();
            weiboService.createWeibo(weiboTitle, weiboContent);
        }
        // 获取所有微博
        List<Weibo> weiboList = weiboService.getWeiboList();
        for (int i = 1; i <= 500; i++) {
            // 随机获取一条微博
            Weibo weibo = weiboList.get(faker.number().numberBetween(0, weiboList.size()));
            String commentContent = faker.lorem().sentence();
            weiboService.createComment(weibo, commentContent);
        }
    }
}
