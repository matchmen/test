package com.mt.https;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * author: liqm
 * 2019-10-25
 */
@SpringBootApplication(scanBasePackages = {"com.mt.*"})
@EnableScheduling
public class HttpsApplication {

        public static void main(String[] args) throws Exception {
            SpringApplication.run(HttpsApplication.class, args);

        }
}
