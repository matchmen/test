package com.mt.mythread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author Liqm
 * @Date 2020/11/24 0024
 */
public class ReadWriteLock {

    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        lock.readLock().lock();
        lock.writeLock().lock();


    }

}
