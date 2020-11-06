package com.lqm.str;

public class Test {

    public static void main(String[] args) {

        String a = "Hello";

        String b = new String("Hello");

        String c = new String("Hello").intern();

        String d = "Hello".intern();

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);

        System.out.println("李:" + "李".getBytes().length);
        System.out.println("a:" + "a".getBytes().length);
        System.out.println("A:" + "A".getBytes().length);
        System.out.println("1:" + "1".getBytes().length);


    }



}
