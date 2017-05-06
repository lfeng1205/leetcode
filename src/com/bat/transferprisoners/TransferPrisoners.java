package com.bat.transferprisoners;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/16.
 * 题目描述
 * C市现在要转移一批罪犯到D市，C市有n名罪犯，按照入狱时间有顺序，另外每个罪犯有一个罪行值，值越大罪越重。
 * 现在为了方便管理，市长决定转移入狱时间连续的c名犯人，同时要求转移犯人的罪行值之和不超过t，问有多少种选择的方式？
 * 输入描述:
 * 第一行数据三个整数:n，t，c(1≤n≤2e5,0≤t≤1e9,1≤c≤n)，第二行按入狱时间给出每个犯人的罪行值ai(0≤ai≤1e9)
 * 输出描述:
 * 一行输出答案。
 * 输入例子:
 * 3 100 2
 * 1 2 3
 * 输出例子:
 * 2
 */
public class TransferPrisoners {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            int n = input.nextInt();//n个人
            int t = input.nextInt();//罪行值之和
            int c = input.nextInt();//要转移的犯人
            int[] value = new int[n];
            for (int i = 0; i < n; i++) {
                value[i] = input.nextInt();
            }

            System.out.println(transferPrisoners(n, t, c, value));
        }
    }

    public static int transferPrisoners(int n, int t, int c, int[] value) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < c; i++) {
            sum += value[i];
        }

        if (sum <= t) {
            count++;
        }

        //计算从1到c犯罪值
        for (int j = c; j < n; j++) {
            sum = sum + value[j] - value[j - c];
            if (sum <= t) {
                count++;
            }
        }
        return count;
    }
}
