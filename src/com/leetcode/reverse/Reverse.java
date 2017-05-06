package com.leetcode.reverse;

/**
 * Created by Feng on 2016/12/8.
 */
public class Reverse {
    public static void main(String[] args) {
        int result = reverse(-123);
        System.out.println("result is " + result);
    }

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }

        StringBuffer buffer = new StringBuffer();
        boolean isFu = x < 0 ? true : false;

        if (isFu) {
            buffer.append("-");
        }

        int y = Math.abs(x);
        while (y % 10 == 0) {// 去掉末尾的0
            y = y / 10;
        }
        while (y / 10 != 0) {
            buffer.append(y % 10);
            y = y / 10;
        }

        buffer.append(y);
        return Integer.parseInt(buffer.toString());
    }
}
