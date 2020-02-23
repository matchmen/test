package com.mt.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: liqm
 * 2020-02-19
 */
@SpringBootApplication(scanBasePackages = {"com.**"})
public class RedisApplication {

    public static void main(String[] args) {

        SpringApplication.run(RedisApplication.class, args);

    }
}