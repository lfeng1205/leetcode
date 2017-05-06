package com.leetcode.romanToInt;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Feng on 2016/12/19.
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInt {
    public static void main(String[] args) {
        String s = "IX";
        int result = romanToInt(s);
        System.out.println("结果是: " + result);
    }

    public static int romanToInt(String s) {
        char[] roman = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int[] num = {1, 5, 10, 50, 100, 500, 1000};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < roman.length; i++) {
            map.put(roman[i], num[i]);
        }

        int res = 0;
        res += map.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int cur = map.get(s.charAt(i));
            int pre = map.get(s.charAt(i - 1));
            //小的数字在大的数字的右边、所表示的数等于这些数字相加得到的数、 如：Ⅷ=8、Ⅻ=12；
            if (cur <= pre) {
                res += cur;
            } else {
                //如果后一位比前一位大这一段的值应该是当前这个值减去上一个值。比如IV = 5 – 1
                res = res + cur - 2 * pre;
            }
        }

        return res;
    }
}
