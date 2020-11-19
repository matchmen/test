package com.lqm.collection.setp;

import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @Author Liqm
 * @Date 2020/11/12 0012
 */
@EqualsAndHashCode
public class SetTest {

    public static void main(String[] args) {

        HashSet<SetTest> set = new HashSet<>();
        set.add(new SetTest());
        set.add(new SetTest());


        TreeSet<String> treeSet = new TreeSet();
        treeSet.add("");
    }
}