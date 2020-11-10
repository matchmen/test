package com.lqm.algorithm;

import java.util.Arrays;

/**
 * 插入算法
 * 原理：插入排序算法有种递归的思想在里面，它由N-1趟排序组成。初始时，只考虑数组下标0处的元素，只有一个元素，显然是有序的。
 * 然后第一趟 对下标 1 处的元素进行排序，保证数组[0,1]上的元素有序；
 * 第二趟 对下标 2 处的元素进行排序，保证数组[0,2]上的元素有序；
 * .....
 * .....
 * 第N-1趟对下标 N-1 处的元素进行排序，保证数组[0,N-1]上的元素有序，也就是整个数组有序了。
 * 它的递归思想就体现在：当对位置 i 处的元素进行排序时，[0,i-1]上的元素一定是已经有序的了。
 * 时间复杂度:①插入排序的时间复杂度 就是判断比较次数有多少，而比较次数与 待排数组的初始顺序有关，当待排数组有序时，没有移动操作（第8行for不成立），此时复杂度为O(N)，当待排数组是逆序时，比较次数达到最大--对于下标 i 处的元素，需要比较 i-1 次。总的比较次数：1+2+...+N-1 ，故时间复杂度为O(N^2)
 * ①可以看出，算法中只用到了一个临时变量（第6行），故空间复杂度为O(1)
 * 其实，插入排序的比较次数与数组的逆序数相关，因为插入排序在将某个元素插入到合适位置时（代码第12行），其实就是消除这个元素的逆序数。
 * 由定理：N个互异数的数组的平均逆序数是 N(N-1)/4，可知：基于相邻元素之间的比较和交换的算法的时间复杂度的一个下界为O(N^2)
 * 比较冒泡排序啊。。。。它采用的思路是：相邻两个元素比较，将小的放在前头。故冒泡排序的时间复杂度为O(N^2)。。。
 * 基于上面这个定理，另外一个排序算法：希尔排序，采用了增量序列。因此，它可能获得一个更好的时间复杂度。
 *
 * 比如，当希尔排序使用Hibbard增量序列时，它的最坏运行时间为O(N3/2)
 *
 * @Author Liqm
 * @Date 2020/11/9 0009
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] num = new int[]{1,23,35,67,2,3,8,0};
        for (int i = 1; i < num.length; i++) {
            int currNum = num[i];
            int j = i;
            for (; j > 0 && currNum > num[j-1]; j--) {
                num[j] = num[j - 1];
            }
            num[j] = currNum;
        }
        Arrays.stream(num).forEach(System.out::println);
    }
}
