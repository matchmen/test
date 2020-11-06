package com.mt.mythread.threadLocal;

/**
 * ThreadLocal:是一种维护线程限制更加规范的方式，运行将每个线程与持有的数据对象绑定在一起，
 * 它提供了get和set访问器方法，为每个使用它的线程维护一份独立的拷贝。
 *
 * author: liqm
 * 2019-10-14
 */
public class MyThreadLocal extends Thread{

    ThreadLocal<String> threadLocal = new ThreadLocal<>();

    private String vaule;

    public MyThreadLocal(String value) {
        this.vaule = value;
    }

    @Override
    public void run() {

        threadLocal.set(vaule);
        threadLocal.remove();

        System.out.println(threadLocal.get());

        Thread thread = new Thread(() -> System.out.println(threadLocal.get()));

        thread.start();


    }
}
