package com.swordOffer.numbersAppearOnce32;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/7.
 */
public class NumbersAppearOnce2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            int[] num1 = new int[1];
            int[] num2 = new int[1];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            findNumsAppearOnce(array, num1, num2);
            System.out.println(num1[0] + "-" + num2[0]);
        }
    }

    private static void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {

        //判断数组是否合法
        if (array == null || array.length < 2) {
            return;
        }

        //记录异或的结果
        int resultExclusiveOR = 0;
        for (int i = 0; i < array.length; i++) {
            resultExclusiveOR ^= array[i];
        }

        //记录1的索引位置
        int indexOfOne = findFirstBitIsOne(resultExclusiveOR);

        num1[0] = 0;
        num2[0] = 0;

        for (int i = 0; i < array.length; i++) {
            if (isBitOne(array[i], indexOfOne)) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    /**
     * 判断num的二进制表示中从右数起的indexBit位是不是1
     * @param num
     * @param indexOfBit
     * @return
     */
    private static boolean isBitOne(int num, int indexOfBit) {

        num = num >> indexOfBit;

        return (num & 1) == 1 ? true : false;
    }

    /**
     * 在整数num的二进制表示中找到最右边是1的位
     * @param num
     * @return
     */
    private static int findFirstBitIsOne(int num) {

        int indexBit = 0;
        while (((num & 1) == 0) && (indexBit < 8 * 4)) {
            num = num >> 1;
            indexBit++;
        }

        return indexBit;
    }
}