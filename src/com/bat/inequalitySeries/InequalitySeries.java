package com.bat.inequalitySeries;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/27.
 * 度度熊最近对全排列特别感兴趣,对于1到n的一个排列,
 * 度度熊发现可以在中间根据大小关系插入合适的大于和小于符号(即 '>' 和 '<' )使其成为一个合法的不等式数列。
 * 但是现在度度熊手中只有k个小于符号即('<'')和n-k-1个大于符号(即'>'),
 * 度度熊想知道对于1至n任意的排列中有多少个排列可以使用这些符号使其为合法的不等式数列。
 * 输入描述:
 * 输入包括一行,包含两个整数n和k(k < n ≤ 1000)
 * <p>
 * 输出描述:
 * 输出满足条件的排列数,答案对2017取模。
 * <p>
 * 输入例子:
 * 5 2
 * <p>
 * 输出例子:
 * 66
 */
public class InequalitySeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //输入数据
            String[] nums = sc.nextLine().split(" ");
            int n = Integer.parseInt(nums[0]);
            int k = Integer.parseInt(nums[1]);//k个小于符号

            int[][] dp = new int[1005][1005];

            for (int i = 1; i <= n; i++) {
                dp[i][0] = 1;
            }

            //dp[i][j]表示前i个数字构成的数列中，
            // 恰有j个‘<’号的方案数（‘>’号就有i - j - 1个）
            for (int i = 2; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    dp[i][j] = (dp[i - 1][j - 1] * (i - j) + dp[i - 1][j] * (j + 1)) % 2017;
                }
            }

            System.out.println(dp[n][k] % 2017);
        }
    }
}
