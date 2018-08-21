package com.spring.aop.pattern.proxy;

import com.spring.aop.pattern.proxy.Subject;
import com.spring.aop.pattern.proxy.impl.MyAdvice;
import com.spring.aop.pattern.proxy.impl.RealSubject;
import com.spring.aop.pattern.proxy.type.SubjectCglibMethodInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author calebman
 * @date 2018/8/16
 * @description 演示jdk动态代理生成的字节码文件
 */
public class SubjectCglibDynamicProxyMain {

    public static void main(String args[]) {
        // 保存生成的字节码文件
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "C:\\Users\\chee\\Desktop");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new SubjectCglibMethodInterceptor(new MyAdvice()));
        Subject subject = (Subject) enhancer.create();
        subject.request();
    }
}
