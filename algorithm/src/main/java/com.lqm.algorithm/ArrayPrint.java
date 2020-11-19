package com.lqm.algorithm;

import java.util.Arrays;

/**
 * @Author Liqm
 * @Date 2020/11/10 0010
 */
public class ArrayPrint {


    public static void print(int[] num) {

        Arrays.stream(num).forEach(a->{
            System.out.print(a+" ");
        });
        System.out.println();

    }
}
