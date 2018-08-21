package com.spring.aop.pattern.proxy;

import com.spring.aop.pattern.proxy.impl.MyAdvice;
import com.spring.aop.pattern.proxy.impl.RealSubject;
import com.spring.aop.pattern.proxy.type.SubjectCglibMethodInterceptor;
import com.spring.aop.pattern.proxy.type.SubjectJdkInvocationHandler;
import com.spring.aop.pattern.proxy.type.SubjectStaticProxy;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 代理模式测试
 */
public class SubjectProxyTest {

    /**
     * 静态代理
     */
    @Test
    public void testStaticProxy() {
        SubjectStaticProxy subject = new SubjectStaticProxy(new RealSubject(), new MyAdvice());
        subject.request();
    }

    /**
     * jdk动态代理
     */
    @Test
    public void testJdkDynamicProxy() {
        Subject subject = (Subject) Proxy.newProxyInstance(SubjectProxyTest.class.getClassLoader(),
                new Class[]{Subject.class},
                new SubjectJdkInvocationHandler(new RealSubject(), new MyAdvice()));
        subject.request();
    }

    /**
     * cglib动态代理
     */
    @Test
    public void testCglibProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new SubjectCglibMethodInterceptor(new MyAdvice()));
        Subject subject = (Subject) enhancer.create();
        subject.request();
    }
}
