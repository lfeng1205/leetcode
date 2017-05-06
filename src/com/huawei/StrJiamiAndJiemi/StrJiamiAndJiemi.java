package com.huawei.StrJiamiAndJiemi;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/1.
 * 题目描述
 * 1、对输入的字符串进行加解密，并输出。
 * 2加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 * <p>
 * 接口描述：
 * 实现接口，每个接口实现1个基本操作：
 * void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出
 * 说明：
 * 1、字符串以\0结尾。
 * 2、字符串最长100个字符。
 * <p>
 * int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出
 * 说明：
 * 1、字符串以\0结尾。
 * 2、字符串最长100个字符。
 */
public class StrJiamiAndJiemi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            char[] chs1 = str1.toCharArray();
            char[] chs2 = str2.toCharArray();
            System.out.println(jiaMi(chs1));
            System.out.println(jieMi(chs2));
        }
    }

    public static String jiaMi(char[] chs) {
        char[] ch = new char[chs.length];
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] >= 'A' && chs[i] < 'Z') {
                //将大写字母转为后一个小写字母
                ch[i] = (char) (chs[i] + 33);
            } else if (chs[i] == 'Z') {
                ch[i] = 'a';
            } else if (chs[i] >= 'a' && chs[i] < 'z') {
                //将小写字母转为后一个大写字母
                ch[i] = (char) (chs[i] - 31);
            } else if (chs[i] == 'z') {
                ch[i] = 'A';
            } else if (chs[i] >= '0' && chs[i] < '9') {
                //将数字加1
                ch[i] = (char) (chs[i] + 1);
            } else if (chs[i] == '9') {
                ch[i] = '0';
            } else {
                ch[i] = chs[i];
            }
        }

        String str = String.valueOf(ch);
        return str;
    }

    public static String jieMi(char[] chs) {
        char[] ch = new char[chs.length];
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] > 'A' && chs[i] <= 'Z') {
                //将大写字母转为前一个小写字母
                ch[i] = (char) (chs[i] + 31);
            } else if (chs[i] == 'A') {
                ch[i] = 'z';
            } else if (chs[i] > 'a' && chs[i] <= 'z') {
                //将小写字母转为前一个大写字母
                ch[i] = (char) (chs[i] - 33);
            } else if (chs[i] == 'a') {
                ch[i] = 'Z';
            } else if (chs[i] > '0' && chs[i] <= '9') {
                //将数字减1
                ch[i] = (char) (chs[i] - 1);
            } else if (chs[i] == '0') {
                ch[i] = '9';
            } else {
                ch[i] = chs[i];
            }

        }
        String str = String.valueOf(ch);
        return str;
    }

}
