package com.bat.lookingDivination;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/10.
 * 牛牛想在[a, b]区间内找到一些数满足可以被一个整数c整除,现在你需要帮助牛牛统计区间内一共有多少个这样的数满足条件？
 * 输入描述:
 * 首先输入两个整数a,b,（-5*10^8 ≤ a ≤ b ≤ 5*10^8)
 * 接着是一个正整数c（1 <= c <= 1000）
 * 输出描述:
 * 输出一个整数表示个数。
 * 输入例子:
 * 0 14 5
 * 输出例子:
 * 3
 */
public class LookingDivination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long a = sc.nextInt();
            long b = sc.nextInt();
            long c = sc.nextInt();

            long res = lookingDivination(a, b, c);
            System.out.println(res);
        }
    }

    private static long lookingDivination(long a, long b, long c) {
        //记录符合的整数的个数
        long count = 0;
        //判断ab是不是同号，分两种情况处理
        if (a * b <= 0) {
            count = Math.abs(a) / c + Math.abs(b) / c + 1;
        } else {
            if (a % c == 0 || b % c == 0) {
                count = (b - a) / c + 1;
            } else {
                count = (b - a) / c;
            }
        }

        return count;
    }
}
