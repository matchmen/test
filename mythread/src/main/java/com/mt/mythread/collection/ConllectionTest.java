package com.mt.mythread.collection;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * author: liqm
 * 2019-10-14
 */
public class ConllectionTest {

    private static void vecktor(){

        Vector<String> vector = new Vector<>();

        vector.add("");
        vector.get(0);

        vector.size();

    }

    private static void iterator() {

        List<String> list = new ArrayList<>();

        list.add("11");
        list.add("22");
        list.add("33");

        Thread thread = new Thread(()->{
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
        });

        thread.start();
    }


    private static void concurrentHashMap() {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        map.putIfAbsent("key", "value");

    }

    private static void queueTest() {

    }

    private static void linkedList() {
        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("111");
    }

    private static void copyOnWriteArrayList() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        //copyOnWriteArrayList.add();
    }


    public static void main(String[] args) {
        // iterator();
    }




}
