package com.mt.mythread.thread;

/**
 * author: liqm
 * 2019-10-22
 */
public class ThreadTest {

    private static int count;

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(()->{
            System.out.println("进入。。。。。。");
            Thread.currentThread().interrupt();
            System.out.println("中断结束..");
        });
        thread.start();
    }

}
