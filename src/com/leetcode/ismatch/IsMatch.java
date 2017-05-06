package com.leetcode.ismatch;

/**
 * Created by Feng on 2016/12/8.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class IsMatch {
    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aaa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("aa", ".*"));
        System.out.println(isMatch("ab", ".*"));
        System.out.println(isMatch("aab", "c*a*b"));
    }

    public static boolean isMatch(String s, String p) {

        if (s == null) {
            return p == null;
        }

        if (p == null) {
            return s == null;
        }

        int sLength = s.length();
        int pLength = p.length();

        if (pLength == 0) {
            return sLength == 0;
        }

        if (pLength == 1) {
            if (p.equals(s) || p.equals(".") && s.length() == 1) {
                return true;
            } else {
                return false;
            }
        }

        // 如没有带*，则判断s和p是否匹配
        if (p.charAt(1) != '*') {
            if (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                return isMatch(s.substring(1), p.substring(1));
            }
            return false;
        } else {
            // 如果p后面有*
            // 匹配0个, 1个和多个
            // 1. 先匹配0个，则直接p+2，若0个不成功，则s++
            // 2. s++表示匹配一个，再看p+2是否成功，否则再s++
            // 3. 这时可能匹配2个，看是否成功，若不成功则继续s++看是否和p匹配
            while (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
                if (isMatch(s, p.substring(2))) {
                    return true;
                }
                s = s.substring(1);
            }
        }

        // 匹配了0个或多个p之后不成功，且s不能和p再匹配了,则p+2，看下个p是否和现在这个s匹配
        return isMatch(s, p.substring(2));
    }
}
