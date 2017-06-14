package com.swordOffer.reverseWordsInSentence35;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/14.
 * 例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseWordsInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String result = ReverseSentence(str);
            System.out.println(result);
        }
    }

    private static String ReverseSentence(String str) {

        if (str == null) {
            return null;
        }

        if (str.trim().equals("")) {
            return str;
        }

        //把字符串分割成字符串数组
        String[] strings = str.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                builder.append(strings[i]);
            } else {
                builder.append(strings[i]).append(" ");
            }
        }

        return builder.toString();
    }
}
