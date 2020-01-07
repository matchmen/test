package com.mt.proxy;

/**
 * author: liqm
 * 2019-09-29
 */
public class DemoImpl implements Demo{
    @Override
    public void print() {

        System.out.println("Hello World!");

    }

    @Override
    public void print1() {
        System.out.println("Hello World Too");
    }
}
