package com.lqm.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Liqm
 * @Date 2020/11/20 0020
 */
public class Test {


    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String> b = a;
        a = new ArrayList<>();
        a.add("ss");
        //

        System.out.println(b.get(0));


    }
}
