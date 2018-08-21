package com.spring.aop.cache;

import com.spring.aop.cache.service.CacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheApplicationTests {
    Logger logger = LoggerFactory.getLogger(CacheApplicationTests.class);

    @Autowired
    CacheService cacheService;

    @Test
    public void contextLoads() {
        for (int i = 1; i <= 3; i++) {
            logger.info("第{}次调用 getMenuList()结果 => {}", i, cacheService.getMenuList().toString());
        }
    }

}
