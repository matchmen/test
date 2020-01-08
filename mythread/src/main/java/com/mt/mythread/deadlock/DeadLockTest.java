package com.mt.mythread.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 运行后使用jstack + 程序进程号  查看线程运行情况
 * 死锁后：
 * Found one Java-level deadlock:
 * =============================
 * "pool-1-thread-2":
 *   waiting to lock monitor 0x00007fe506827568 (object 0x000000076adc6030, a java.lang.Object),
 *   which is held by "pool-1-thread-1"
 * "pool-1-thread-1":
 *   waiting to lock monitor 0x00007fe5068274b8 (object 0x000000076adc6040, a java.lang.Object),
 *   which is held by "pool-1-thread-2"
 *
 *   "pool-1-thread-2":
 *         at com.mt.mythread.deadlock.LeftRigthDeadLock.rightLeft(LeftRigthDeadLock.java:27)
 *         - waiting to lock <0x000000076adc6030> (a java.lang.Object)
 *         - locked <0x000000076adc6040> (a java.lang.Object)
 * "pool-1-thread-1":
 *         at com.mt.mythread.deadlock.LeftRigthDeadLock.leftRight(LeftRigthDeadLock.java:17)
 *         - waiting to lock <0x000000076adc6040> (a java.lang.Object)
 *         - locked <0x000000076adc6030> (a java.lang.Object)
 *
 *  两条线程相互持有对方需要的锁
 *
 * author: liqm
 * 2019-10-21
 */
public class DeadLockTest {

    public static void main(String[] args) {

//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//
//        LeftRigthDeadLock leftRigthDeadLock = new LeftRigthDeadLock();

//        executorService.execute(()->{
//            for (int i = 0; i < 100000; i++) {
//                leftRigthDeadLock.leftRight();
//            }
//
//        });
//
//        executorService.execute(()->{
//            for (int i = 0; i < 100000; i++) {
//                leftRigthDeadLock.rightLeft();
//            }
//        });



    }

}
