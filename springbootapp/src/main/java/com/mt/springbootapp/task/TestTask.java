package com.mt.springbootapp.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * author: liqm
 * 2019-11-14
 */
@Component
public class TestTask {

    @Scheduled(cron = "0 35/1 10-12 * * ?")
    public void print() {

        System.out.println("开始吧");

    }

}
