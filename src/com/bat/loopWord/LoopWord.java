package com.bat.loopWord;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Feng on 2017/3/20.
 * 如果一个单词通过循环右移获得的单词，我们称这些单词都为一种循环单词。
 * 例如：picture 和 turepic 就是属于同一种循环单词。 现在给出n个单词，需要统计这个n个单词中有多少种循环单词。
 * 输入描述:
 * 输入包括n+1行：
 * <p>
 * 第一行为单词个数n(1 ≤ n ≤ 50)
 * <p>
 * 接下来的n行，每行一个单词word[i]，长度length(1 ≤ length ≤ 50)。由小写字母构成
 * <p>
 * <p>
 * 输出描述:
 * 输出循环单词的种数
 * <p>
 * 输入例子:
 * 5
 * picture
 * turepic
 * icturep
 * word
 * ordw
 * <p>
 * 输出例子:
 * 2
 */
public class LoopWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int line = sc.nextInt();//输入行数

        sc.nextLine();//空一行输入

        Set<String> set = new HashSet<>();//存放单词
        int count = 0;

        for (int i = 0; i < line; i++) {
            String word = sc.nextLine();
            if (!set.contains(word)) {//如果set不包含word 则加入
                count++;
                set.add(word);

                String loopWord = change(word);//右移一个字母
                while (!loopWord.equals(word)) {//不断循环
                    set.add(loopWord);
                    loopWord = change(loopWord);
                }
            }
        }

        System.out.println(count);
    }

    public static String change(String word) {
        String loopWord = word.substring(word.length() - 1) + word.substring(0, word.length() - 1);
        return loopWord;
    }
}
