package com.swordOffer.kLeastNumbers21;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Feng on 2017/5/23.
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * O(n)的算法，只有当我们可以修改输入的数组时可以使用
 */
public class KLeastNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组大小
            int k = sc.nextInt();//k的值
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }

            ArrayList<Integer> result = getLeastNumbers(input, k);
            for (Integer i : result) {
                System.out.print(i + "\t");
            }
        }
    }

    public static ArrayList<Integer> getLeastNumbers(int[] input, int k) {

        //存放最小的k个值
        ArrayList<Integer> list = new ArrayList<>();

        //如果数组的大小小于k则返回list
        if (input.length < k) {
            return list;
        }

        findKMin(input, 0, input.length - 1, k);

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }

        return list;
    }

    /**
     * 寻找k个最小的数
     *
     * @param input
     * @param begin
     * @param end
     * @param k
     */
    private static void findKMin(int[] input, int begin, int end, int k) {
        if (begin < end) {
            int index = partition(input, begin, end);
            if (index == k - 1) {
                return;
            } else if (index < k - 1) {
                findKMin(input, index + 1, end, k);
            } else {
                findKMin(input, begin, index - 1, k);
            }
        }
    }

    /**
     * 利用分治的思想将比第k个数字小的数字移到左边，比第k个大的移到右边
     *
     * @param input
     * @param begin
     * @param end
     * @return
     */
    private static int partition(int[] input, int begin, int end) {
        //设立标兵
        int pivot = input[begin];
        while (begin < end) {
            //从后往前找到比pivot小的就停止
            while (begin < end && input[end] >= pivot) {
                end--;
            }

            input[begin] = input[end];

            //从前往后找到比pivot大的就停止
            while (begin < end && input[begin] <= pivot) {
                begin++;
            }

            input[end] = input[begin];
        }
        input[begin] = pivot;
        return begin;
    }
}
