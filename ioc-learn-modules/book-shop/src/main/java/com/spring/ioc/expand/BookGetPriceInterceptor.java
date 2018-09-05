package com.spring.ioc.expand;

import com.spring.ioc.book.BookInterface;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author calebman
 * @date 2018/9/5
 * @description
 */
public class BookGetPriceInterceptor implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 获取调用对象
        Object target = methodInvocation.getThis();
        Object result = null;
        if (target instanceof BookInterface) {
            if (target instanceof OffRateInterface) {
                OffRateInterface book = (OffRateInterface) target;
                // 计算折扣率
                result = book.getPrice() * book.getOffRate() * 0.1;
            } else {
                BookInterface book = (BookInterface) target;
                // 兼容之前版本
                result = book.getPrice();
            }
        } else {
            result = methodInvocation.proceed();
        }
        return result;
    }
}
