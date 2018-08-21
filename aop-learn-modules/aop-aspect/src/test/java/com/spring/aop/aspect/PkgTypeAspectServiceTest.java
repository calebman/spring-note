package com.spring.aop.aspect;

import com.spring.aop.aspect.service.pkg.PkgTypeAspectService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PkgTypeAspectServiceTest {

    @Autowired
    PkgTypeAspectService pkgTypeAspectService;

    @Test
    public void doBussiness() {
        pkgTypeAspectService.doBussiness();
    }
}