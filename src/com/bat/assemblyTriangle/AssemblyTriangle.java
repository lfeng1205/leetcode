package com.bat.assemblyTriangle;

/**
 * Created by Feng on 2017/4/10.
 * 牛牛手里有N根木棒,分别编号为1~N,现在他从N根里想取出三根木棒，使得三根木棒构成一个三角形,
 * 你能计算出牛牛有多少种取法吗?(考虑两种取法中使用的木棒编号有一个不一样就认为是不同的取法)。
 * 输入描述:
 * 首先输入一个正整数N，接下来的一行共有N个正整数表示每个木棒的长度。
 * N ≤ 50, 木棒的长度 ≤ 10000.
 * 输出描述:
 * 输出一个整数表示方法数。
 * 输入例子:
 * 5
 * 1 2 3 4 5
 * 输出例子:
 * 3
 */

import java.util.Arrays;
import java.util.Scanner;

public class AssemblyTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();//有N个木棒
            int[] sticks = new int[N];
            for (int i = 0; i < N; i++) {
                sticks[i] = sc.nextInt();
            }
            int res = assemblyTriangle(sticks, N);
            System.out.println(res);
        }
    }

    //暴力枚举法
    private static int assemblyTriangle(int[] sticks, int n) {
        int count = 0;
        Arrays.sort(sticks);
        for (int i = 0; i < sticks.length; i++) {
            for (int j = i + 1; j < sticks.length; j++) {
                for (int k = j + 1; k < sticks.length; k++) {
                    //三角形定理：两边之和大于第三边
                    if (sticks[i] + sticks[j] > sticks[k]) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }
}
