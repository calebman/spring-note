package com.spring.ioc.value;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
@Configuration
@ImportResource("classpath:spring-properties.xml")
public class JdbcConfig {

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
