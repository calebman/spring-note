package com.spring.aop.aspect;

import com.spring.aop.aspect.service.annotation.AnnotationAspectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotationAspectServiceTest {

    @Autowired
    AnnotationAspectService annotationAspectService;

    @Test
    public void doBussiness() {
        annotationAspectService.doBussiness();
    }

    @Test
    public void doArgs() {
        annotationAspectService.doArgs("calebman");
    }
}
