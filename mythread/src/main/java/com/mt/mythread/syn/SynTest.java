package com.mt.mythread.syn;

/**
 * @Author Liqm
 * @Date 2020/11/10 0010
 */
public class SynTest {

    public static void main(String[] args) {
        synchronized (SynTest.class) {
        }
        System.out.println(SynTest.class);
        method();
    }
    private synchronized static void method() { }
}
