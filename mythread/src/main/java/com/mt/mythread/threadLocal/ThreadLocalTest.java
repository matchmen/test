package com.mt.mythread.threadLocal;

/**
 * author: liqm
 * 2019-10-14
 */
public class ThreadLocalTest {

    public static void main(String[] args) {

        MyThreadLocal myThreadLocal = new MyThreadLocal("线程1");

        myThreadLocal.start();

    }

}
