package com.swordOffer.regularExpressionsMatching45;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/24.
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class RegularExpressionsMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            String patterns = sc.nextLine();

            char[] str = strs.toCharArray();
            char[] pattern = patterns.toCharArray();

            boolean result = match(str, pattern);
            System.out.println(result);
        }
    }

    private static boolean match(char[] str, char[] pattern) {

        if (str == null || pattern == null) {
            return false;
        }

        int strIndex = 0;//字符串的索引
        int patternIndex = 0;//模式中的索引

        return matchCore(str, strIndex, pattern, patternIndex);
    }

    private static boolean matchCore(char[] str, int strIndex,
                                     char[] pattern, int patternIndex) {

        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length && patternIndex == pattern.length) {
            return true;
        }

        //如果pattern先到尾，返回false
        if (strIndex != str.length && patternIndex == pattern.length) {
            return false;
        }

        //模式第2个字符是*，且字符串第1个字符跟模式第1个字符匹配,
        // 分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                    || (pattern[patternIndex] == '.'&& strIndex != str.length)) {
                //模式后移2，视为x*匹配0个字符
                return matchCore(str, strIndex, pattern, patternIndex + 2)
                        //视为模式匹配1个字符
                        || matchCore(str, strIndex + 1, pattern, patternIndex + 2)
                        //*匹配1个，再匹配str中的下一个
                        || matchCore(str, strIndex + 1, pattern, patternIndex);
            } else {
                return matchCore(str, strIndex, pattern, patternIndex + 2);
            }
        }

        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length && pattern[patternIndex] == str[strIndex])
                || (pattern[patternIndex] == '.' && strIndex != str.length)) {
            return matchCore(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
