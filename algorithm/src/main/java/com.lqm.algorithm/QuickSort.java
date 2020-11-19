package com.lqm.algorithm;

/**
 * 快速排序
 * 原理:分别从初始序列“6  1  2 7  9  3  4  5 10  8”两端开始“探测”。
 * 先从右往左找一个小于6的数，再从左往右找一个大于6的数，然后交换他们。
 * 这里可以用两个变量i和j，分别指向序列最左边和最右边。
 *
 * 时间复杂度分析: 快速排序之所比较快，因为相比冒泡排序，每次交换是跳跃式的。
 * 每次排序的时候设置一个基准点，将小于等于基准点的数全部放到基准点的左边，将大于等于基准点的数全部放到基准点的右边。
 * 这样在每次交换的时候就不会像冒泡排序一样每次只能在相邻的数之间进行交换，
 * 交换的距离就大的多了。因此总的比较和交换次数就少了，速度自然就提高了。
 * 当然在最坏的情况下，仍可能是相邻的两个数进行了交换。
 * 因此快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)
 * @Author Liqm
 * @Date 2020/11/10 0010
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] num = new int[]{6, 8, 2, 7, 9, 3, 4, 5, 10, 1};
        sort(num, 0, num.length - 1);
        ArrayPrint.print(num);
    }

    public static void sort(int[] num,int left,int right) {
        System.out.println("left:" + left + ",right:" + right);
        ArrayPrint.print(num);
        if(left >= right)return;
        int i = left, j = right, temp = num[left];
        while (i != j) {
            while(num[j] >= temp && i < j){
                j--;
            }
            while(num[i] <= temp && i < j){
                i++;
            }
            if (i < j) {
                int curr = num[i];
                num[i] = num[j];
                num[j] = curr;
            }
        }
        num[left] = num[i];
        num[i] = temp;
        sort(num,left,i-1);
        sort(num, i + 1, right);
    }
}
