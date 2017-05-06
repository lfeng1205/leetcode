package com.leetcode.longestCommonPrefix;

/**
 * Created by Feng on 2016/12/20.
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {

        String[] strings = {"abdc", "abced"};
        String result = longestCommonPrefix(strings);
        System.out.println("结果是: " + result);
    }

    public static String longestCommonPrefix(String[] strings) {

        if (strings == null || strings.length == 0) {
            return "";
        }

        for (int i = 0; i < strings[0].length(); i++) {
            char ch = strings[0].charAt(i);
            for (int j = 1; j < strings.length; j++) {
                //使用反向排除
                if (strings[j].length() == i || strings[j].charAt(i) != ch) {
                    return strings[0].substring(0, i);
                }
            }
        }

        return strings[0];
    }
}
