package com.bat.longestSubString;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/10.
 * <p>
 * 牛牛有两个字符串（可能包含空格）,牛牛想找出其中最长的公共连续子串,希望你能帮助他,并输出其长度。
 * 输入描述:
 * 输入为两行字符串（可能包含空格），长度均小于等于50.
 * 输出描述:
 * 输出为一个整数，表示最长公共连续子串的长度。
 * 输入例子:
 * abcde
 * abgde
 * 输出例子:
 * 2
 */
public class LongestSubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //输入两个字符串
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.print(longestSubString(str1, str2));
    }

    public static int longestSubString(String str1, String str2) {

        if (str1.length() == 0 || str2.length() == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = i; j <= str1.length(); j++) {
                //获取字符子串
                StringBuffer sb1 = new StringBuffer(str1.substring(i - 1, j));
                //判断字符串2是否包含字符子串
                if (str2.contains(sb1)) {
                    if (sb1.length() >= max) {
                        //得到最大的字符子串
                        max = sb1.length();
                    }
                }
            }
        }
        return max;
    }
}
