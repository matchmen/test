package com.lqm.algorithm;

import java.util.Arrays;

/**
 * 选择排序
 * 参考：https://www.cnblogs.com/shen-hua/p/5424059.html
 * 原理：每一趟从待排序的记录中选出最小的元素，顺序放在已排好序的序列最后，
 * 直到全部记录排序完毕。也就是：每一趟在n-i+1(i=1，2，…n-1)个记录中选取关键字
 * 最小的记录作为有序序列中第i个记录。基于此思想的算法主要有简单选择排序、树型选择排序和堆排序。
 *
 * 选择排序的时间复杂度：简单选择排序的比较次数与序列的初始排序无关。 假设待排序的序列有 N 个元素，
 * 则比较次数永远都是N (N - 1) / 2。而移动次数与序列的初始排序有关。当序列正序时，移动次数最少，为 0。
 * 当序列反序时，移动次数最多，为3N (N - 1) /  2。
 * 所以，综上，简单排序的时间复杂度为 O(N2)
 * @Author Liqm
 * @Date 2020/11/6 0006
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] num = new int[]{1,23,35,67,2,3,8,0};

        for (int i = 0; i < num.length; i++) {
            int minNumIndex = i;
            for (int j = i + 1; j < num.length; j++) {//循环比较，找更小
                if (num[minNumIndex] > num[j]) { //选出最小数下标，并且记录于minNumIndex,
                    minNumIndex = j;
                }
            }
            if(i != minNumIndex){ //一轮过后
                int currNum = num[i];
                num[i] = num[minNumIndex];
                num[minNumIndex] = currNum;
            }
        }
        Arrays.stream(num).forEach(System.out::println);
    }
}
