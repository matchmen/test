package com.mt.logprint.task;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Component
public class Task {

    @Value("${params.username}")
    private String username;

    @Scheduled(cron = "${tasks.task1.cron}")
    public void execute() {

        log.info("username:{}", username);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Book book = new Book();

        CountDownLatch countDownLatch = new CountDownLatch(2);

        executorService.execute(() -> {
            for (; ; ) {
                book.produce();
            }

        });

        executorService.execute(() -> {
            for (; ; ) {
                book.consumer();
            }
        });

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
