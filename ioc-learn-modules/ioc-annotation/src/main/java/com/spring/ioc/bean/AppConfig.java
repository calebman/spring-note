package com.spring.ioc.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Configuration
public class AppConfig {

    /**
     * 等价于
     * <bean id="myService" class="com.spring.ioc.bean.MyService"></bean>
     *
     * @return MyService
     */
    @Bean(initMethod = "init", destroyMethod = "destory")
    public MyService myService() {
        return new MyService();
    }
}
