package com.spring.aop.aspect;

import com.spring.aop.aspect.service.execution.ExecutionAspectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExecutionAspectServiceTest {

    @Autowired
    ExecutionAspectService executionAspectService;

    @Test
    public void insert() {
        executionAspectService.insert("calebman");
    }

    @Test
    public void findById() {
        executionAspectService.findById(1L);
    }

    @Test
    public void deleteAll() {
        executionAspectService.deleteAll();
    }

    @Test(expected = Exception.class)
    public void allException() throws Exception {
        executionAspectService.allException();
    }

    @Test(expected = RuntimeException.class)
    public void runntimeException() {
        executionAspectService.runntimeException();
    }
}