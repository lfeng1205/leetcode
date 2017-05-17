package com.swordOffer.moreThanHalfNumber20;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/17.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNumber {

    private static boolean inputInvalid = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组的大小
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }

            int result = morethanHalfNumber(numbers, n);
            System.out.println(result);
        }
    }

    private static int morethanHalfNumber(int[] numbers, int length) {

        if (checkInvalidArray(numbers, length)) {
            return 0;
        }

        int result = numbers[0];
        int times = 1;
        for (int i = 1; i < length; i++) {
            if (times == 0) {
                result = numbers[i];
                times = 1;
            } else if (numbers[i] == result) {
                times++;
            } else {
                times--;
            }
        }

        if (!checkMoreThanHalf(numbers, length, result)) {
            return 0;
        }

        return result;

    }

    /**
     * 判断数组输入是否合法
     *
     * @param numbers
     * @param length
     * @return
     */
    private static boolean checkInvalidArray(int[] numbers, int length) {

        inputInvalid = false;

        //判断数组是否为空
        if (numbers == null || length <= 0) {
            inputInvalid = true;
        }

        return inputInvalid;
    }

    /**
     * 判断数组中是否存在有超过长度一半的数字
     *
     * @param numbers
     * @param length
     * @param number
     * @return
     */
    private static boolean checkMoreThanHalf(int[] numbers, int length, int number) {

        int times = 0;
        for (int i = 0; i < length; i++) {
            if (numbers[i] == number) {
                times++;
            }
        }

        boolean isMoreThanHalf = true;
        if (times * 2 <= length) {
            inputInvalid = true;
            isMoreThanHalf = false;
        }

        return isMoreThanHalf;
    }
}
