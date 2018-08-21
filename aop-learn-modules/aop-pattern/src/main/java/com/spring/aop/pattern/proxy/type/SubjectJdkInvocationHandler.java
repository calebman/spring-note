package com.spring.aop.pattern.proxy.type;

import com.spring.aop.pattern.proxy.Advice;
import com.spring.aop.pattern.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理的实现
 * <p>
 * 只能代理有接口的类的接口方法进行动态代理
 *
 * @see Proxy#newProxyInstance(ClassLoader, Class[], InvocationHandler)
 */
public class SubjectJdkInvocationHandler implements InvocationHandler {

    private Subject subject;

    private Advice advice;

    public SubjectJdkInvocationHandler(Subject subject, Advice advice) {
        this.subject = subject;
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        advice.before();
        Object result = null;
        try {
            result = method.invoke(subject, args);
            advice.afterRetunning();
        } catch (Exception ex) {
            advice.afterThrowing();
            throw ex;
        } finally {
            advice.after();
        }
        return result;
    }
}
