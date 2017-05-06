package com.swordOffer.Fibonacci07;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/6.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 */
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//一共有n个数

            int result = fibonacci(n);
            System.out.println(result);
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        int fibOne = 1;
        int fibTwo = 0;
        int fibSum = 0;

        for (int i = 2; i <= n; i++) {

            fibSum = fibOne + fibTwo;//求两个数之和

            fibTwo = fibOne;
            fibOne = fibSum;
        }

        return fibSum;
    }
}
