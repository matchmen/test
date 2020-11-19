package com.mt.mythread.volatiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author Liqm
 * @Date 2020/11/12 0012
 */
public class VolatileTest {

    private static volatile int a;
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    a++;
                }
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println(a);
    }
}
