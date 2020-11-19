package com.lqm.collection.queue;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @Author Liqm
 * @Date 2020/11/12 0012
 */
public class QueueTest {

    public static void main(String[] args) {


//        Queue<String> queue = new ConcurrentLinkedQueue();
//
//        queue.add("aa");
//        queue.add("bb");
//        queue.add("cc");
//
//        System.out.println(queue.element());
//        System.out.println(queue.poll());
//        System.out.println(queue);
//
//        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
//        concurrentLinkedQueue.add("");
//
//        PriorityQueue priorityQueue = new PriorityQueue();
//        priorityQueue.add("");

        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(100);
        arrayBlockingQueue.add("aaa");
        arrayBlockingQueue.add("bbb");
        arrayBlockingQueue.add("ccc");
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());
        System.out.println(arrayBlockingQueue.poll());

        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        linkedBlockingDeque.add("");


    }


}
