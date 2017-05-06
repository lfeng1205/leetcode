package com.leetcode.longestCommonString;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/9.
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            int res = longestCommonSubString(str1, str2);
            System.out.println(res);
        }
        sc.close();
    }

    public static int longestCommonSubString(String str1, String str2) {
        int[][] c = new int[str1.length() + 1][str2.length() + 1];
        int max = 0;//记录最长公共子串的长度

        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;//如果字符相等数组加1
                    max = Math.max(c[i][j], max);

                } else {
                    c[i][j] = 0;
                }
            }
        }

        return max;
    }
}
