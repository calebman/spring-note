package com.spring.aop.scene;

import com.spring.aop.scene.security.CurrentUserHolder;
import com.spring.aop.scene.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SceneApplicationTests {

    @Autowired
    ProductService productService;

    @Test(expected = RuntimeException.class)
    public void tomRemove() {
        CurrentUserHolder.set("tom");
        productService.removeProduct(1L);
    }

    @Test
    public void adminRemove() {
        CurrentUserHolder.set("admin");
        productService.removeProduct(1L);
    }

}
