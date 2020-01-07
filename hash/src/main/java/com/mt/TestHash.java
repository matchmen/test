package com.mt;

import java.util.Hashtable;

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

    }


}
