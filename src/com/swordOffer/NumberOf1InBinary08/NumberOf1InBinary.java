package com.swordOffer.NumberOf1InBinary08;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/6.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOf1InBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int result = numberOf1(n);
            System.out.println(result);
        }
    }

    private static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }

        return count;
    }
}
