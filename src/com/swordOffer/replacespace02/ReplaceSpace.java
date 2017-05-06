package com.swordOffer.replacespace02;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/30.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strs = sc.nextLine();
            System.out.println(replaceSpace(strs));
        }
    }

    private static String replaceSpace(String strs) {

        if (strs == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder(strs);
        for (int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);
            if (ch == ' ') {
                builder.replace(i, i + 1, "%20");
            }
        }

        return builder.toString();

    }

}
