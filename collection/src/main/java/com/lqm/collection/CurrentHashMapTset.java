package com.lqm.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Liqm
 * @Date 2020/10/15 0015
 */
public class CurrentHashMapTset {

    public static void main(String[] args) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String,String>(100);

        concurrentHashMap.put("","");
        concurrentHashMap.get("");
        concurrentHashMap.size();

        Hashtable hashtable = new Hashtable();
        hashtable.put("", "");

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.stream().forEach(System.out::printf);

        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("","");
        System.out.println();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        list.parallelStream().forEach(System.out::printf);



    }





}
