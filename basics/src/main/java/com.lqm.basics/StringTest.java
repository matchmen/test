package com.lqm.basics;

/**
 * @Author Liqm
 * @Date 2020/11/16 0016
 */
public class StringTest {

    public static final String a = "123";
    public static final String b = "456";

    public static void main(String[] args) {

        /**
         * (1)使用引号创建的字符串直接在常量池中拿对象
         * (2)只要使用new方法，便需要创建新的对象
         */
        String str1 = "aaa";
        String str2 = "aaa";
        System.out.println(str1 == str2);

        String str3 = "aaa";
        String str4 = new String("aaa");
        System.out.println(str3 == str4);

        /**
         * （1）只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对象才会被加入字符串池中。
         * （2）对于所有包含new方式新建对象（包括null）的“+”连接表达式，它所产生的新对象都不会被加入字符串池中。
         */
        String str5 = "aaa" + "aaa"; //将加入字符串常量池
        String str6 = "aaaaaa"; //不会加入字符串常量池，因为str4是使用new创建的
        System.out.println(str5 == str6);

        /**
         * （1）两个常量值是固定的，他们的+结果的值也是固定的，它在类被编译时就已经确定了，所以
         * （2）被定义为常量，如果它们都没有马上被赋值。在运算出+结果之前，他们何时被赋值，以及被赋予什么样的值，
         *      都是个变数。因此A和B在被赋值之前，性质类似于一个变量。那么s就不能在编译期被确定，而只能在运行时被创建了。
         */
        final String str7 = "aaa";
        final String str8 = "aaa";
        String str10 = str7 + str8;
        String str11 = str7 + str8;
        System.out.println(str10 == str11);

        final String str12;
        final String str13;
        str12 = "ccc";
        str13 = "ccc";
        String str14 = str12 + str13;
        String str15 = str12 + str13;
        System.out.println(str14 == str15);


    }
}
