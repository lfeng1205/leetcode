package com.swordOffer.print1ToMaxOfDigits09;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/7.
 * 输入数字n，按顺序打印从1到n位十进制。比如输入3，则打印出1、2、3一直到最大的3位数999
 */
public class Print1ToMaxOfDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] number = new int[n];
//            while (!increment(number)) {
//                printNumber(number);
//            }
            printMaxOfNdigits2(n);

        }
    }

    /**
     * 这个方法是用来实现对数加1操作
     *
     * @param number
     * @return
     */
    public static boolean increment(int[] number) {
        boolean isOverflow = false;//是否有进位
        int nTakeOver = 0;
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] + nTakeOver;
            if (i == nLength - 1) {
                nSum++;
            }
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nTakeOver = 1;
                    nSum = nSum - 10;
                    number[i] = nSum;
                }
            } else {
                number[i] = nSum;
                break;
            }
        }
        return isOverflow;
    }

    /**
     * 该方法是负责打印
     *
     * @param number
     */
    public static void printNumber(int[] number) {
        boolean isBegining = true;
        for (int i = 0; i < number.length; i++) {
            if (isBegining && number[i] != 0) {
                isBegining = false;
            }
            if (!isBegining) {
                System.out.print(number[i]);
            }
        }
    }

    /**
     * 全排序列实现
     *
     * @param number
     * @param length
     * @param index
     */
    public static void printMaxOfNdigitsRecursively(int[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[index + 1] = i;
            printMaxOfNdigitsRecursively(number, length, index + 1);
        }
    }

    public static void printMaxOfNdigits2(int n) {
        if (n <= 0)
            return;
        int[] number = new int[n];
        for (int i = 0; i < 10; i++) {
            number[0] = i;
            printMaxOfNdigitsRecursively(number, n, 0);
        }
    }
}
