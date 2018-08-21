package com.spring.aop.aspect.aspect.config;

import com.spring.aop.aspect.aspect.advice.BaseAdviceConfig;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author calebman
 * @date 2018/8/15
 * @description 使用execution表达式匹配切面的用法
 * execution(修饰符 返回值 包名 方法名 参数 异常)
 */
@Aspect
@Component
public class ExecutionAspectConfig extends BaseAdviceConfig {

    // 通过方法签名定义切点
    // 匹配所有public方法
//    @Pointcut("execution(public * *(..))")
    // 匹配所有以exception结尾的方法
    @Pointcut("execution(* *Exception(..))")
    // 通过类定义切点
    // 匹配ExecutionAspectService的所有方法
//    @Pointcut("execution(* com.spring.aop.aspect.service.execution.ExecutionAspectService.*(..))")
    // 通过类包定义切点
    // 匹配com.spring.aop.aspect.service.execution包下的所有类的所有方法
//    @Pointcut("execution(* com.spring.aop.aspect.service.execution.*(..))")
    // 匹配com.spring.aop.aspect.service包下的所有类、子孙包下所有类的所有方法
//    @Pointcut("execution(* com.spring.aop.aspect.service..*(..))")
    // 匹配com包下的所有类以及所有子孙包的所有类中类名后缀为Service的方法
//    @Pointcut("execution(* com..*.*Service(..))")
    // 通过方法入参定义切点
    // 匹配execution包下的所有类的所有只有一个类型为long的参数的方法
//    @Pointcut("execution(public * com.spring.aop.aspect.service.execution.ExecutionAspectService.*(long)))")
    // 匹配有两个参数且第一个参数为long的方法
//    @Pointcut("execution(* com.spring.aop.aspect.service.execution.ExecutionAspectService.*(long,*)))")
    // 匹配第一个参数为long的方法
//    @Pointcut("execution(* com.spring.aop.aspect.service.execution.ExecutionAspectService.*(long,..)))")
    // 匹配只有一个参数且参数为Object类型或者为其子类的方法
//    @Pointcut("execution(* com.spring.aop.aspect.service.execution.ExecutionAspectService.*(Object+)))")
    // 匹配抛出Exception异常的方法
//    @Pointcut("execution(public * *(..) throws java.lang.Exception)")
    // 匹配抛出RuntimeException异常的方法
//    @Pointcut("execution(public * *(..) throws java.lang.RuntimeException)")
    @Override
    public void match() {
    }
}
