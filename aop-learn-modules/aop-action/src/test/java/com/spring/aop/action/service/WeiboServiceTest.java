package com.spring.aop.action.service;

import com.spring.aop.action.pojo.Weibo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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
        for (int i = 1; i <= 50; i++) {
            weiboService.createWeibo("测试标题", "这是一条测试微博[" + generatorStr(160) + "]");
        }
        // 获取所有微博
        List<Weibo> weiboList = weiboService.getWeiboList();
        for (int i = 1; i <= 500; i++) {
            // 随机获取一条微博
            Weibo weibo = weiboList.get(new Random().nextInt(weiboList.size()));
            weiboService.createComment(weibo, "这是生成的第" + i + "条测试评论[" + generatorStr(80) + "]");
        }
    }

    /**
     * 生成随机的字符串
     *
     * @param len 字符串长度
     * @return 生成的字符串
     */
    public static String generatorStr(int len) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            int number = random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
