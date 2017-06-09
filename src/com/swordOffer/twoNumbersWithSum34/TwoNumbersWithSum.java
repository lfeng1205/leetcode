package com.swordOffer.twoNumbersWithSum34;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Feng on 2017/6/9.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class TwoNumbersWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            ArrayList<Integer> result = findNumbersWithSum(array, sum);
            for (Integer i : result) {
                System.out.print(i + " ");
            }
        }
    }

    private static ArrayList<Integer> findNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        if (array.length < 1 || sum < 2) {
            return arrayList;
        }

        int start = 0, end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                arrayList.add(array[start]);
                arrayList.add(array[end]);
                break;
            }

            //如果大于sum，不断将end--
            while ((start < end) && (array[start] + array[end] > sum)) {
                end--;
            }

            //如果小于sum，不断将start++
            while ((start < end) && (array[start] + array[end] < sum)) {
                start++;
            }
        }

        return arrayList;
    }
}
