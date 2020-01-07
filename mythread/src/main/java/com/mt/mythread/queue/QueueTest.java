package com.mt.mythread.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * author: liqm
 * 2019-10-22
 */
public class QueueTest {

    /** 阻塞队列接口 BlockingQueue */
    private static BlockingDeque linkedBlockingDeque = new LinkedBlockingDeque(10000);
    private static BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue<String>(100);

    public static void main(String[] args) {

        BlockingPutThread putThread = new BlockingPutThread();
        BlockingTakeThread takeThread = new BlockingTakeThread();

        putThread.start();

        takeThread.start();

    }

    static class BlockingPutThread extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    arrayBlockingQueue.put("xxxx");
                    System.out.println("queue size is:" + arrayBlockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BlockingTakeThread extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    String s = (String)arrayBlockingQueue.take();
                    System.out.println("take:" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
