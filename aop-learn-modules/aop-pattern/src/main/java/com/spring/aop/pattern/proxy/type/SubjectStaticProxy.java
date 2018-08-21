package com.spring.aop.pattern.proxy.type;

import com.spring.aop.pattern.proxy.Advice;
import com.spring.aop.pattern.proxy.Subject;

/**
 * 静态代理的实现
 * 缺点
 * 代理方法越多重复逻辑越多 目标类有一百个方法就得委托一百个方法 前后逻辑都得执行
 */
public class SubjectStaticProxy implements Subject {

    private Subject subject;

    private Advice advice;

    public SubjectStaticProxy(Subject subject, Advice advice) {
        this.subject = subject;
        this.advice = advice;
    }

    @Override
    public void request() {
        advice.before();
        try {
            subject.request();
            advice.afterRetunning();
        } catch (Exception ex) {
            advice.afterThrowing();
        } finally {
            advice.after();
        }
    }
}
