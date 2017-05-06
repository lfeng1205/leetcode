package com.leetcode.longestPalindrome;

/**
 * Created by Feng on 2016/12/1.
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring.
 */
public class LongestPalindrome {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNext()) {
//            String s = sc.next();
//            String result = longestPalindrome(s);
//            System.out.println("result is " + result.length());
//        }

        String s = "ABBAK";
        String res = longestPalindrome(s);
        System.out.println(res.length());

    }

    /**
     * public static String longestPalindrome(String s) {
     * <p>
     * //最大回文字符串的长度
     * int maxPaliLength = 0;
     * //最长回文字符串
     * String longestPalindrome = null;
     * //字符串长度
     * int length = s.length();
     * <p>
     * for (int i = 0; i < length; i++) {
     * for (int j = i+1; j < length; j++) {
     * int len = j - i;
     * String curr = s.substring(i, j + 1);
     * if (isPalindrome(curr)) {
     * if (len > maxPaliLength) {
     * longestPalindrome = curr;
     * maxPaliLength = len;
     * }
     * }
     * }
     * }
     * <p>
     * return longestPalindrome;
     * }
     * <p>
     * public static boolean isPalindrome(String s) {
     * for (int i = 0; i < s.length() - 1; i++) {
     * if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
     * return false;
     * }
     * }
     * return true;
     * }
     */

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append('$').append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }

        String res = manacher(sb.toString());
        return res;
    }


    public static String manacher(String str) {
        int[] p = new int[str.length()];//p[i]记录以Str[i]字符为中心的最长回文串半径
        int id = 0;//id表示最大回文子串中心的位置
        int mx = 0;//mx则为id+P[id]，也就是最大回文子串的边界
        p[0] = 1;
        for (int i = 1; i < str.length(); i++) {
            if (mx > i) {
                p[i] = p[2 * id - i] < mx - i ? p[2 * id - i] : mx - i;
            } else {
                p[i] = 1;
            }
            while (i - p[i] >= 0 && i + p[i] < str.length() && (str.charAt(i - p[i]) ==
                    str.charAt(i + p[i]))) {
                p[i]++;
            }
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }
        int max = 0;
        for (int i = 1; i < p.length; i++) {
            if (p[i] > max) {
                max = p[i];
                id = i;
            }
        }
        int start = id - max + 1;
        int end = id + max - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            if (str.charAt(i) != '#')
                sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
