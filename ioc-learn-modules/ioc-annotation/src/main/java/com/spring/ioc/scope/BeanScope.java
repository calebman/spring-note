package com.spring.ioc.scope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope
@Component
public class BeanScope {

    public void say() {
        System.out.println("BeanAnnotation hascode is " + this.hashCode());
    }

}
