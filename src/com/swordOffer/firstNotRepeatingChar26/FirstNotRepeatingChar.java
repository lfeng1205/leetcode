package com.swordOffer.firstNotRepeatingChar26;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/3.
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * <p>
 * 输出描述
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class FirstNotRepeatingChar {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char result = firstAppearingOnce(str);
            System.out.println(result);
        }
    }

    private static char firstAppearingOnce(String str) {
        int[] count = new int[256];
        String res = "";

        //将字符串转化为字符存入数组，然后找出只出现一次的字符，
        // 组成新的字符串
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
            if (count[str.charAt(i)] == 1) {
                res += str.charAt(i);
            }
        }

        //遍历新的字符串，找到第一个等于1的字符
        for (int i = 0; i < res.length(); i++) {
            char ch = res.charAt(i);
            if (count[ch] == 1) {
                return ch;
            }
        }

        return '#';
    }
}
