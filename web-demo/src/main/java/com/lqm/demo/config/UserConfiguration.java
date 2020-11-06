package com.lqm.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Liqm
 * @Date 2020/8/25 0025
 */
@Configuration
public class UserConfiguration {
    @Bean("user")
    @ConfigurationProperties(prefix = "user")
    public User user() {
        return new User();
    }
}
