package com.lqm.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序算法
 * 原理: 有2种思路，
 * 第一种，num[j] 和 num[j+1] 比较 如果 前者比后者小，把前者和后者调换顺序，两两调换后一轮下来 最小的会被排到最后去。
 * 每一轮j都从0开始，当i轮排序，就有最后面的i个数字因为他是最小的，所以后面的每轮都不用理他了，也就是 score.length-1-i  往后的数不用管了；
 *
 * 第二种，跟第一种相反，num[i+1] > num[1]时候，把两个位置
 * @Author Liqm
 * @Date 2020/11/6 0006
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] num = new int[]{1,23,35,67,2,3,8,0};
        sort1(num);
        //sort2(num);
    }

    public static void sort1(int[]num) {

        for (int i = 0; i < num.length; i++) {
            for (int j = 0; j < num.length - i - 1; j++) {
                if (num[j] < num[j + 1]) {
                    int currNum = num[j];
                    num[j] = num[j+1];
                    num[j + 1] = currNum;
                }
            }
            Arrays.stream(num).forEach(a->{System.out.print(a);
                System.out.print(" ");});
            System.out.println();
        }
        Arrays.stream(num).forEach(System.out::println);
    }

    public static void sort2(int[]num) {

        for (int i = 0; i < num.length; i++) {
            for (int j = num.length - 1; j >0; j--) {
                if (num[j] < num[j - 1]) {
                    int currNum = num[j];
                    num[j] = num[j - 1];
                    num[j - 1] = currNum;
                }
            }
        }
        System.out.println("方法二");
        Arrays.stream(num).forEach(System.out::println);
    }
}
