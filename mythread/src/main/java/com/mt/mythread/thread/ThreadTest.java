package com.mt.mythread.thread;

/**
 * author: liqm
 * 2019-10-22
 */
public class ThreadTest {

    private static int count;

    public static void main(String[] args) throws InterruptedException {

        YieldThreadTest yieldThreadTest = new YieldThreadTest();

        yieldThreadTest.start();

        Thread thread = new Thread();

    }

    private synchronized static void add() {
        Long st = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            Thread.yield();
            count++;
        }

        System.out.println("耗时:" + (System.currentTimeMillis() - st));
    }

    static class YieldThreadTest extends Thread{

        @Override
        public void run() {
            add();
        }
    }

}
