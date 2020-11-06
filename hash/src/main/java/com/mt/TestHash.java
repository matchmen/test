package com.mt;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * author: liqm
 * 2019-12-18
 */
public class TestHash {

    public static void main(String[] args) {


        Hashtable<String, String> hashtable = new Hashtable<>();

        hashtable.put("aaa", "aaaa");
        hashtable.put("bbb", "bbbb");
        hashtable.put("bbb", "cccc");

        System.out.println(hashtable);

        HashMap<String, String> map = new HashMap<>();

        map.put("a", "ax");
        map.put("a", "ax");

        map.get("a");

        System.out.println(map.size());
        System.out.println(8 >>> 2);

    }


}
