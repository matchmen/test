package com.mt.mythread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Liqm
 * @Date 2020/11/13 0013
 */
public class LockTest {
    private static ReentrantLock lock = new ReentrantLock(false);
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
                try {
                    Thread.sleep(10_000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    System.out.println(Thread.currentThread().getName()+"释放锁");
                    lock.unlock();
                }
            }).start();
        }
    }


}
