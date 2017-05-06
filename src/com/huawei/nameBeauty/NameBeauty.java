package com.huawei.nameBeauty;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Feng on 2017/3/22.
 * 题目描述
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * <p>
 * 输入描述:
 * 整数N，后续N个名字
 * <p>
 * <p>
 * 输出描述:
 * 每个名称可能的最大漂亮程度
 * <p>
 * 输入例子:
 * 2
 * zhangsan
 * lisi
 * <p>
 * 输出例子:
 * 192
 * 101
 */
public class NameBeauty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            String[] names = new String[N];
            for (int i = 0; i < N; i++) {
                names[i] = sc.next();
            }
            nameBeauty(names, N);
        }
    }

    public static void nameBeauty(String[] names, int N) {
        for (int i = 0; i < N; i++) {
            int[] count = new int[26];//26个字母数组
            int length = names[i].length();//每个名字的长度
            for (int j = 0; j < length; j++) {
                int asc = names[i].charAt(j);//获取每个字符的大小
                if (asc >= 'A' && asc <= 'Z') {
                    count[asc - 65]++;
                } else if (asc >= 'a' && asc <= 'z') {
                    count[asc - 97]++;
                }
            }
            //对count进行排序
            Arrays.sort(count);

            int beauty = 0;
            for (int k = 0; k < 26; k++) {
                //漂亮度之和
                beauty = beauty + count[k] * (k + 1);
            }
            System.out.println(beauty);
        }
    }
}
