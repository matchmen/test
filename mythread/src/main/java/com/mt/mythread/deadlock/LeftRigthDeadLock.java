package com.mt.mythread.deadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author: liqm
 * 2019-10-21
 */
public class LeftRigthDeadLock {

    /** synchronized 同步**/
    private final Object leftObject = new Object();

    private final Object rigthObject = new Object();

    /*** lock类锁 ***/
    private Lock leftLock = new ReentrantLock();

    private Lock rightLock = new ReentrantLock();

    public void leftRight(){

        /*** synchronized 同步 ***/
//        synchronized (leftObject){
//            synchronized (rigthObject){
//                System.out.println(Thread.currentThread().getName() + ":left right lock!");
//            }
//        }

        /*** lock类锁 ***/

        if(leftLock.tryLock()){
            System.out.println(Thread.currentThread().getName() + ":get left lock!");
            try {
                if(rightLock.tryLock()){
                    try {
                        System.out.println(Thread.currentThread().getName() + ":get right lock!");
                    }finally {
                        rightLock.unlock();
                        System.out.println(Thread.currentThread().getName() + " release left lock!");
                    }
                }

            }finally {
                leftLock.unlock();
                System.out.println(Thread.currentThread().getName() + " release left lock!");
            }
        }

    }

    public void rightLeft(){

        /*synchronized (rigthObject){
            synchronized (leftObject){
                System.out.println(Thread.currentThread().getName() + ":right left lock!");
            }
        }*/

        /*** lock类锁 ***/

        if(rightLock.tryLock()){
            System.out.println(Thread.currentThread().getName() + ":get right lock!");
            try {
                if(leftLock.tryLock()){
                    try {
                        System.out.println(Thread.currentThread().getName() + ":get left lock!");
                    }finally {
                        leftLock.unlock();
                        System.out.println(Thread.currentThread().getName() + " release left lock!");
                    }
                }

            }finally {
                rightLock.unlock();
                System.out.println(Thread.currentThread().getName() + " release right lock!");
            }
        }

    }

}
