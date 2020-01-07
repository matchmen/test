package com.mt.jdk18stream;

/**
 * author: liqm
 * 2019-09-25
 */
public class StaticDispatch {

    static abstract class Human{
    }
    static class Man extends Human{
    }
    static class Woman extends Human{
    }
    public void sayHello(Human guy) {
        System.out.println("hello,guy ");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman ");
    }

    public void sayHello(Woman guy){
        System.out.println("hello,lady ");
    }


    public static void main(String[]args){
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello((Man) man);
        sr.sayHello((Woman) woman);

//        System.out.println(('a'+'a')/2);
//        System.out.println(('A'+'A')/2);
//        System.out.println(('z'+'z')/2);
//        System.out.println(('Z'+'Z')/2);
//        System.out.println(('1'+'1')/2);
//        System.out.println(('9'+'9')/2);
//        System.out.println(('0'+'0')/2);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Character.MAX_RADIX);
        System.out.println("沐+聪=" + ('沐' + '聪'));

    }

}


