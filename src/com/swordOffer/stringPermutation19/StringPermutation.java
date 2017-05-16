package com.swordOffer.stringPermutation19;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by Feng on 2017/5/16.
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class StringPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            ArrayList<String> result = permutation(str);
            for (String string : result) {
                System.out.println(string);
            }
        }
    }

    public static ArrayList<String> permutation(String str) {

        ArrayList<String> arrayList = new ArrayList<>();

        //判断字符串是否为空
        if (str == null || str.length() == 0) {
            return arrayList;
        }

        //获取字符串的字符数组
        char[] chs = str.toCharArray();

        //利用TreeSet没有重复元素的特点，去除重复的排列
        TreeSet<String> treeSet = new TreeSet<>();

        permutation(chs, 0, treeSet);

        //将排列存入ArrayList集合
        arrayList.addAll(treeSet);

        return arrayList;
    }

    private static void permutation(char[] chs, int begin, TreeSet<String> treeSet) {

        if (chs == null || chs.length == 0 || begin < 0 || begin > chs.length - 1) {
            return;
        }

        //如果只有一个字符，直接将该字符加入treeSet
        if (begin == chs.length - 1) {
            treeSet.add(String.valueOf(chs));
        } else {
            for (int i = begin; i < chs.length; i++) {
                //固定一个字符，然后交换其余的字符
                //如果i和begin相等则不需要交换，继续递归
                if (i != begin) {
                    swap(chs, begin, i);
                }

                //递归操作后面的字符
                permutation(chs, begin + 1, treeSet);

                if (i != begin) {
                    swap(chs, begin, i);
                }
            }
        }

    }

    /**
     * 交换字符
     * @param chs
     * @param x
     * @param y
     */
    private static void swap(char[] chs, int x, int y) {
        char temp = chs[x];
        chs[x] = chs[y];
        chs[y] = temp;
    }
}
