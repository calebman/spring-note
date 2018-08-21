package com.spring.aop.scene.service;

import com.spring.aop.scene.annotation.AdminOnly;
import com.spring.aop.scene.pojo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 产品服务
 */
@Service
public class ProductService {
    Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    AuthService authService;

    /**
     * 添加产品
     *
     * @param product
     */
    @AdminOnly
    public void addProduct(Product product) {
        // 传统方法
//        authService.checkAccess();
        // ...bussiness
        log.info("add product success");
    }

    /**
     * 移除产品
     *
     * @param id
     */
    @AdminOnly
    public void removeProduct(Long id) {
        // 传统方法
//        authService.checkAccess();
        // ...bussiness
        log.info("remove product success");
    }
}
