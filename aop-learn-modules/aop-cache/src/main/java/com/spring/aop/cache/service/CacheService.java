package com.spring.aop.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author calebman
 * @date 2018/8/17
 * @description 缓存演示服务类
 */
@Service
public class CacheService {
    Logger logger = LoggerFactory.getLogger(CacheService.class);

    @Cacheable("menus")
    public List<String> getMenuList() {
        logger.info("####从数据库中获得菜单列表####");
        return Arrays.asList("角色管理", "用户管理", "操作日志");
    }
}
