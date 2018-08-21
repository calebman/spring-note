package com.spring.aop.aspect;

import com.spring.aop.aspect.service.args.ArgsAspectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArgsAspectServiceTest {

    @Autowired
    ArgsAspectService argsAspectService;

    @Test
    public void insertUser() {
        argsAspectService.insertUser("calebman", "123456");
    }

    @Test
    public void deleteUser() {
        argsAspectService.deleteUser(1L);
    }

    @Test
    public void getAllUser() {
        argsAspectService.getAllUser();
    }
}