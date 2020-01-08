package com.mt.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author: liqm
 * 2020-01-07
 */
@MapperScan(basePackages = {"com.mt.**.mapper"})
@SpringBootApplication(scanBasePackages = {"com.mt.**"})
public class App {
    public static void main(String[] args) {

        SpringApplication.run(App.class, args);

    }
}