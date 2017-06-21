package com.swordOffer.duplicateNumberInArray43;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/21.
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class DuplicateNumberInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //数组的大小
            int n = sc.nextInt();
            int[] numbers = new int[n];
            int[] duplication = new int[1];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }

            boolean result = Duplicate(numbers, n, duplication);
            System.out.println(result + "---" + duplication[0]);
        }
    }

    private static boolean Duplicate(int[] numbers, int length, int[] duplication) {

        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(numbers[i] + "");
        }

        for (int j = 0; j < length; j++) {
            //通过索引位置来判断有没有重复
            //如果数字在不同的索引位置出现，则有重复数字
            if (buffer.indexOf(numbers[j] + "") !=
                    buffer.lastIndexOf(numbers[j] + "")) {
                duplication[0] = numbers[j];
                return true;
            }
        }
        return false;
    }
}
