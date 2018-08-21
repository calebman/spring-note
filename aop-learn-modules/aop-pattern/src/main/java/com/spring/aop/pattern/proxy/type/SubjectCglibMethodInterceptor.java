package com.spring.aop.pattern.proxy.type;

import com.spring.aop.pattern.proxy.Advice;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


import java.lang.reflect.Method;

/**
 * Cglib动态代理实现
 * <p>
 * 基于继承来实现代理，无法对static final的类 以及 private static的方法进行代理
 */
public class SubjectCglibMethodInterceptor implements MethodInterceptor {

    private Advice advice;

    public SubjectCglibMethodInterceptor(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        advice.before();
        Object result = null;
        try {
            result = methodProxy.invokeSuper(o, objects);
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
