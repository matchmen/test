package com.mt.mythread.threadpool;


import java.util.concurrent.*;

/**
 * author: liqm
 * 2019-10-18
 */
public class ThreadPoolSaturatedPolicyTest {

    private static int num = 0;

    private synchronized static void add() {

        num = num + 1;

        System.out.println(Thread.currentThread().getName() + ":" + num);

    }

    /**
     * 任务队列满了就终止
     */
    private static void abortPolicy(){

        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(10000);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 2L, TimeUnit.HOURS, blockingDeque,
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 2000000; i++) {
            executor.execute(()->{
                add();
            });
        }
        System.out.println("num计算结果:" + num);

    }

    /**
     */
    private static void discardPolicy(){

        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(10000);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 2L, TimeUnit.HOURS, blockingDeque,
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 2000000; i++) {
            executor.execute(()->{
                add();
            });
        }
        System.out.println("num计算结果:" + num);

    }

    /**
     */
    private static void discardOldestPolicy(){

        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(100);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 2L, TimeUnit.HOURS, blockingDeque,
                new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 10000; i++) {
            executor.execute(()->{
                add();
            });
        }
        System.out.println("num计算结果:" + num);

    }


    /**
     */
    private static void callerRunsPolicy(){

        BlockingDeque<Runnable> blockingDeque = new LinkedBlockingDeque<>(100);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 2L, TimeUnit.HOURS, blockingDeque,
                new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 1000000; i++) {
            executor.execute(()->{
                add();
            });
        }
        System.out.println("num计算结果:" + num);

    }



    public static void main(String[] args) {
        //abortPolicy();

        //discardPolicy();

        //discardOldestPolicy();

        callerRunsPolicy();
    }


}
