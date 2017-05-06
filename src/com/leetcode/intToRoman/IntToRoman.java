package com.leetcode.intToRoman;

/**
 * Created by Feng on 2016/12/19.
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999
 */
public class IntToRoman {
    public static void main(String[] args) {
        String result = intToRoman(123);
        System.out.println("结果是: " + result);
    }

    public static String intToRoman(int num) {
        String[][] roman = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};

        String result = "";
        int digit = 0;
        while (num != 0) {
            int remain = num % 10;
            result = roman[digit][remain] + result;
            digit++;
            num = num / 10;
        }

        return result;
    }
}
