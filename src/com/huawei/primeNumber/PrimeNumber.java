package com.huawei.primeNumber;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/28.
 * <p>
 * 题目描述
 * 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。
 * 现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，
 * 挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，
 * 而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，
 * 当然密码学会希望你寻找出“最佳方案”。输入:有一个正偶数N（N≤100），表示待挑选的自然数的个数。
 * 后面给出具体的数字，范围为[2,30000]。输出:输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。
 */
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int index = 0;
            while (index < n) {
                arr[index++] = sc.nextInt();
            }
            System.out.println(getPrimePairs(arr, n));
        }

        sc.close();
    }

    public static int getPrimePairs(int[] arr, int n) {
        if (arr == null || n == 0 || n % 2 != 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        int count = 0;
        /*
        * 从后向前看
        * 利用动态规划解题，dp[i]表示(n-1)~i最多有的伴侣数
        * 当v[i]+v[j]为素数。dp[i]+dp[j-1] = dp[i+1]+dp[j+1]+1;
        * 由于伴侣数成对出现，必然只能在i-1和j-1的基础上出现一对。
        * 当v[i]+v[j]不为素数。dp[i]=dp[i+1]
         */
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (isPrime(arr[i] + arr[j])) {
                    count = dp[i + 1] + dp[j + 1] - dp[j - 1] + 1;
                } else {
                    count = dp[i + 1];
                }
                dp[i] = Math.max(count, dp[i]);
            }

        }

        return dp[0];

    }

    public static boolean isPrime(int m) {
        if (m == 2) {
            return true;
        }

        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(m); i++) {
            if (m % i == 0) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }

}
