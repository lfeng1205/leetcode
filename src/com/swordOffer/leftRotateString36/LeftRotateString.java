package com.swordOffer.leftRotateString36;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/14.
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int n = sc.nextInt();
            String result = leftRotateString(str, n);
            System.out.println(result);
        }
    }

    private static String leftRotateString(String str, int n) {

        if (str == null || str.length() <= 0) {
            return null;
        }

        StringBuilder oldBuilder = new StringBuilder(str);
        StringBuilder curBuilder = new StringBuilder(str);
        StringBuilder newBuilder = new StringBuilder();

        oldBuilder.delete(0, n);
        curBuilder.delete(n, str.length());
        newBuilder.append(oldBuilder.toString())
                .append(curBuilder.toString());

        return newBuilder.toString();
    }
}
