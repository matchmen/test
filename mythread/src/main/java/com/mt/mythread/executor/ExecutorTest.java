package com.mt.mythread.executor;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.*;

/**
 * author: liqm
 * 2019-10-16
 */
public class ExecutorTest {


    private static void executors() throws ExecutionException, InterruptedException {

        //        Executor executor = Executors.newFixedThreadPool(2);
//
//
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(Thread.currentThread().getName()+":"+1000);
//            }
//        });

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(LocalDateTime.now()+":执行中。。。。");
                Thread.sleep(2000L);
                System.out.println(LocalDateTime.now()+":经过");
                return "value";
            }
        });

        future.get();

    }


    private static void completionService() throws InterruptedException, ExecutionException {

        CountDownLatch countDownLatch = new CountDownLatch(2);

        ExecutorService executor = Executors.newFixedThreadPool(2);

        CompletionService completionService = new ExecutorCompletionService(executor);

        Future<String> submit = completionService.submit(() -> {
            try {
                return Thread.currentThread().getName() + ":completionService task1";
            } finally {
                countDownLatch.countDown();
            }
        });

        String s = submit.get();

        completionService.submit(()->{
            try {
                return Thread.currentThread().getName() + ":completionService task2";
            }finally {
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();

        for (int i = 0; i < 2; i++) {
            Future<String> future = completionService.take();
            if(!Objects.isNull(future))
                System.out.println(future.get());
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        completionService();
    }





}
