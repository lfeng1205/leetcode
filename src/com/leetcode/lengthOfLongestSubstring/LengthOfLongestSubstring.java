package com.leetcode.lengthOfLongestSubstring;

import java.util.HashSet;

/**
 * Created by Feng on 2016/11/26.
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String string = "abcabcbca";
        int result = lengthOfLongestSubstring(string);
        System.out.println("result is " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashSet<Character> set = new HashSet<>();
        int runner = 0;//表示字符串的索引
        int walker = 0;//表示子串的索引
        int max = 0;

        for (; runner < s.length(); runner++) {
            if (set.contains(s.charAt(runner))) {
                max = (runner - walker) > max ? (runner - walker) : max;
                while (s.charAt(walker) != s.charAt(runner)) {
                    set.remove(s.charAt(walker));
                    walker++;
                }
                walker++;
            } else {
                set.add(s.charAt(runner));
            }
        }

        max = (runner - walker) > max ? (runner - walker) : max;
        return max;
    }
}
