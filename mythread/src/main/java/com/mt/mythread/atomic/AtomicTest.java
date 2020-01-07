package com.mt.mythread.atomic;

import sun.misc.Unsafe;

/**
 * author: liqm
 * 2019-10-17
 */
public class AtomicTest {

    public static void main(String[] args) {

        Unsafe.getUnsafe().addressSize();

        System.out.println(Unsafe.ADDRESS_SIZE);

    }



}
