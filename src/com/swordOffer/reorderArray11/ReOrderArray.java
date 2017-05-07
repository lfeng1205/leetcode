package com.swordOffer.reorderArray11;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/7.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分
 */
public class ReOrderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组大小
            int[] number = new int[n];
            for (int i = 0; i < n; i++) {
                number[i] = sc.nextInt();
            }

            int[] result = reorderArray(number);
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.println(result[i]);
                } else {
                    System.out.print(result[i] + " ");
                }
            }
        }
    }

    //不保证奇数偶数的相对位置不变
    private static int[] reorderArray(int[] number) {

        //判断是否为空
        if (number == null || number.length <= 0) {
            return null;
        }

        //两个索引，一个指向数组的第一个数
        //一个指向数组的最后一个数
        int low = 0;
        int high = number.length - 1;

        while (low < high) {
            //向后移动low，直到它指向偶数
            while (low < high && (number[low] % 2 != 0)) {
                low++;
            }

            //向前移动high，直到它指向奇数
            while (low < high && (number[high] % 2 == 0)) {
                high--;
            }

            if (low < high) {
                int temp = number[low];
                number[low] = number[high];
                number[high] = temp;
            }
        }

        return number;
    }

    //可以保证奇数和偶数相对位置不变
    public static int[] reOrderArray2(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }

        return array;
    }
}
