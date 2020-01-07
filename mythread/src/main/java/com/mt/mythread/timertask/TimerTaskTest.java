package com.mt.mythread.timertask;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * author: liqm
 * 2019-10-16
 */
public class TimerTaskTest {

    public static void main(String[] args) {

        executorSchedule();

    }


    public static void timerTaskTest() {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName()+":timer task1 execute!");

            }
        }, 2000L, 1000L);
    }

    public static void executorSchedule() {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        executor.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + ":executorSchedule task2 execute!");
        }, 2L, 2L, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(() -> {
            System.out.println(Thread.currentThread().getName() + ":executorSchedule task3 execute!");
        }, 2L, 2L, TimeUnit.SECONDS);


    }
}
