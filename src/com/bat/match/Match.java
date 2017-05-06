package com.bat.match;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/26.
 */
public class Match {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();//需要过滤的字符串
        String pattern = sc.nextLine();//匹配模式

        int strIndex = 0;
        int patternIndex = 0;
        boolean flag = match(inputStr, strIndex, pattern, patternIndex);
        if (flag == true) {
            System.out.println(1);
        } else  {
            System.out.println(0);
        }
    }

    public static boolean match(String str, int strIndex, String pattern, int patternIndex) {

        //有效性检验：str到尾，pattern到尾，匹配成功
        if (strIndex == str.length() && patternIndex == pattern.length()) {
            return true;
        }
        //pattern先到尾，匹配失败
        if (strIndex != str.length() && patternIndex == pattern.length()) {
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (patternIndex + 1 < pattern.length() && pattern.charAt(patternIndex + 1) == '*') {
            if ((strIndex != str.length() && pattern.charAt(patternIndex) == str.charAt(strIndex)) ||
                    (pattern.charAt(patternIndex) == '?' && strIndex != str.length())) {

                return match(str, strIndex, pattern, patternIndex + 2)//模式后移2，视为x*匹配0个字符
                        || match(str, strIndex + 1, pattern, patternIndex + 2)//视为模式匹配1个字符
                        || match(str, strIndex + 1, pattern, patternIndex);


            } else {
                return match(str, strIndex, pattern, patternIndex + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIndex != str.length() && pattern.charAt(patternIndex) == str.charAt(strIndex)) ||
                (pattern.charAt(patternIndex) == '?' && strIndex != str.length())) {
            return match(str, strIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }
}
