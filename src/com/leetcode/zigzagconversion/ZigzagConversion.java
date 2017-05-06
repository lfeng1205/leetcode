package com.leetcode.zigzagconversion;

public class ZigzagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int nRows = 4;
        String strings = convert(s, nRows);
        System.out.println("�����: " + strings);
    }

    public static String convert(String s, int nRows) {

        StringBuffer string = new StringBuffer();

        if (s == null || s.length() <= nRows || nRows <= 1) {
            return s;
        }

        // ��һ��
        for (int i = 0; i < s.length(); i += 2 * (nRows - 1)) {
            string.append(s.charAt(i));
        }

        // �м���
        for (int i = 1; i < nRows - 1; i++) {
            int index = 2 * i;
            for (int j = i; j < s.length(); j += index) {
                string.append(s.charAt(j));
                index = 2 * nRows - 2 - index;
            }
        }

        // ���һ��
        for (int i = nRows - 1; i < s.length(); i += 2 * (nRows - 1)) {
            string.append(s.charAt(i));
        }

        return string.toString();
    }
}
