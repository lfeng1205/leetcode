package com.huawei.interceptString;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/23.
 * 题目描述
 * 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。
 * 但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。
 * <p>
 * 输入描述:
 * 输入待截取的字符串及长度
 * <p>
 * <p>
 * 输出描述:
 * 截取后的字符串
 * <p>
 * 输入例子:
 * 我ABC汉DEF
 * 6
 * <p>
 * 输出例子:
 * 我ABC
 */
public class InterceptString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //要截取的字符串
            String inputStr = sc.next();
            //截取的长度
            int num = Integer.parseInt(sc.next());
            String res = interceptString(inputStr, num);
            System.out.println(res);
        }
    }

    public static String interceptString(String str, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0, len = 0; i < str.length() && len < n; i++) {
            char ch = str.charAt(i);
            if ((int) ch > 255) {//如果是汉字
                if (len + 2 > n) {
                    break;
                }
                builder.append(ch);
                len = len + 2;//位置向后移动2
            }
            if (ch >= 0 && ch <= 255) {//如果是非汉字
                builder.append(ch);
                len++;
            }
        }
        return builder.toString();
    }
}
