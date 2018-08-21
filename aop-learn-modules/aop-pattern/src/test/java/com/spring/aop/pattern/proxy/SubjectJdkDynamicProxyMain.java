package com.spring.aop.pattern.proxy;

import com.spring.aop.pattern.proxy.impl.MyAdvice;
import com.spring.aop.pattern.proxy.impl.RealSubject;
import com.spring.aop.pattern.proxy.type.SubjectJdkInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * @author calebman
 * @date 2018/8/16
 * @description 演示jdk动态代理生成的字节码文件
 */
public class SubjectJdkDynamicProxyMain {

    public static void main(String args[]) {
        // 保存生成的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Subject subject = (Subject) Proxy.newProxyInstance(SubjectJdkDynamicProxyMain.class.getClassLoader(),
                new Class[]{Subject.class},
                new SubjectJdkInvocationHandler(new RealSubject(), new MyAdvice()));
        subject.request();
    }
}
