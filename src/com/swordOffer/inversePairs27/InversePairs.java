package com.swordOffer.inversePairs27;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/5.
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 */
public class InversePairs {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            int result = inversePairs(array);
            System.out.println(result);
        }
    }

    private static int inversePairs(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int[] copy = new int[array.length];

        //复制数组
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }

        int count = inversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;
    }

    private static int inversePairsCore(int[] array, int[] copy, int low, int high) {

        if (low == high) {
            return 0;
        }

        int mid = (low + high) >> 1;

        //分治递归将数组分成两个左右两个子数组
        int leftCount = inversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = inversePairsCore(array, copy, mid + 1, high) % 1000000007;

        //i初始化为前半段最后一个数字的下标
        int i = mid;
        //j初始化为后半段最后一个数字的下标
        int j = high;
        int indexCopy = high;
        int count = 0;

        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[indexCopy--] = array[i--];
                //数值过大求余
                if (count >= 1000000007) {
                    count %= 1000000007;
                }
            } else {
                copy[indexCopy--] = array[j--];
            }
        }

        for (; i >= low; i--) {
            copy[indexCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[indexCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }

        return (leftCount + rightCount + count) % 1000000007;
    }
}
