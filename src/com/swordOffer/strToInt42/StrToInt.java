package com.swordOffer.strToInt42;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/20.
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * <p>
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 * +2147483647
 * 1a33
 * <p>
 * 2147483647
 * 0
 */
public class StrToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String inputStr = sc.nextLine();
            int result = strToInt(inputStr);
            System.out.println(result);
        }
    }

    private static int strToInt(String str) {

        if (str.equals(" ") || str.length() == 0) {
            return 0;
        }

        char[] chs = str.toCharArray();
        int sign = 0;
        if (chs[0] == '-') {
            sign = 1;//为负数
        }

        //结果
        int sum = 0;

        for (int i = sign; i < chs.length; i++) {
            if (chs[i] == '+') {
                continue;
            }
            if (chs[i] < 48 || chs[i] > 57) {
                return 0;
            }

            sum = sum * 10 + chs[i] - 48;
        }
        return sum == 0 ? sum : sum * -1;
    }
}
