package com.bat.createNewWorld;

/**
 * Created by Feng on 2017/4/12.
 * 众所周知计算机代码底层计算都是0和1的计算，牛牛知道这点之后就想使用0和1创造一个新世界！
 * 牛牛现在手里有n个0和m个1，给出牛牛可以创造的x种物品，每种物品都由一个01串表示。
 * 牛牛想知道当前手中的0和1可以最多创造出多少种物品。
 * 输入描述:
 * 输入数据包括x+1行：
 * 第一行包括三个整数x(2 ≤ x ≤ 20)，n(0 ≤ n ≤ 500)，m(0 ≤ m ≤ 500)，以空格分隔
 * 接下来的x行，每行一个01串item[i]，表示第i个物品。每个物品的长度length(1 ≤ length ≤ 50)
 * 输出描述:
 * 输出一个整数，表示牛牛最多能创造多少种物品
 * 输入例子:
 * 3 3 1
 * 1
 * 00
 * 100
 * 输出例子:
 * 2
 */

import java.util.Scanner;

public class CreateNewWorld {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] zero = new int[x];//有n个0
            int[] one = new int[x];//有m个1

            String item;
            for (int i = 0; i < x; i++) {
                item = sc.nextLine();
                int count = 0;//统计0的个数
                for (int j = 0; j < item.length(); j++) {
                    if (item.charAt(i) == '0') {
                        count++;
                    }
                }
                zero[i] = count;
                one[i] = item.length() - count;
            }

            int[][] dp = new int[n + 1][m + 1];
            for (int i = 0; i < x; i++) {
                for (int j = n; j >= zero[i]; j--) {
                    for (int k = m; k >= one[i]; k--) {
                        if (dp[j][k] < dp[j - zero[i]][k - one[i]] + 1) {
                            dp[j][k] = dp[j - zero[i]][k - one[i]] + 1;
                        }
                    }
                }
            }

            System.out.println(dp[n][m]);
        }
    }
}
