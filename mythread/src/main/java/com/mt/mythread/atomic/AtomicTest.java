package com.mt.mythread.atomic;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * author: liqm
 * 2019-10-17
 */
public class AtomicTest {

    public static void main(String[] args) throws InterruptedException {
        intTest();
        reference();

        AtomicInteger atomicInteger = new AtomicInteger(1);
        boolean b = atomicInteger.compareAndSet(0, 2);
        System.out.println(atomicInteger.get());
    }

    private static void reference() throws InterruptedException {
        AtomicObj atomicObj = new AtomicObj("","");
        AtomicReference<AtomicObj> atomicReference = new AtomicReference(atomicObj);
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 50; j++) {
                    atomicReference.getAndSet(new AtomicObj(Thread.currentThread().getName(), Thread.currentThread().getName()));
                }
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println(atomicReference.get());
    }

    private static void intTest() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 50; j++) {
                    atomicInteger.getAndAdd(1);
                }
                countDownLatch.countDown();
            });
            thread.start();
        }
        countDownLatch.await();
        System.out.println(atomicInteger.get());
    }




}
