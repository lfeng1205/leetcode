package com.swordOffer.numericStrings46;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/25.
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class NumericStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.nextLine();
            char[] chars = string.toCharArray();
            boolean result = isNumeric(chars);
            System.out.println(result);
        }
    }

    private static boolean isNumeric(char[] str) {

        int length = str.length;

        if (str == null || length == 0) {
            return false;
        }

        int index = 0;
        if (str[index] == '+' || str[index] == '-') {
            index++;
            if (index == length) {
                return false;
            }
        }

        //判断当前位是否为数字
        index = scanDigit(str, index);

        if (index != length) {
            //判断是否为浮点数
            if (str[index] == '.') {
                index++;
                if (index == length) {
                    return false;
                }

                index = scanDigit(str, index);
                if (index == length) {
                    return true;
                }

                // 后接科学计数
                if (str[index] == 'e' || str[index] == 'E') {
                    return isExponential(str, index);
                } else {
                    return false;
                }
            } else if ((str[index] == 'e' || str[index] == 'E')) {
                return isExponential(str, index);
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是否为e或者E为底的科学计数
     * @param str
     * @param index
     * @return
     */
    private static boolean isExponential(char[] str, int index) {

        if (str[index] != 'e' && str[index] != 'E') {
            return false;
        }

        index++;

        if (index == str.length) {
            return false;
        }

        if (str[index] == '+' || str[index] == '-') {
            index++;
            if (index == str.length) {
                return false;
            }
        }
        //科学计数法e后面的数字必须是不为0的整数
        //且不能为空
        index = scanDigit(str, index);
        return index == str.length;
    }

    /**
     * 判断当前位是否是合法的数字
     *
     * @param str
     * @param index
     * @return
     */
    private static int scanDigit(char[] str, int index) {

        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }

        return index;
    }
}
