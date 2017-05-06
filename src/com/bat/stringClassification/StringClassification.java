package com.bat.stringClassification;


/**
 * Created by Feng on 2017/4/12.
 * 牛牛有N个字符串，他想将这些字符串分类，他认为两个字符串A和B属于同一类需要满足以下条件：
 * A中交换任意位置的两个字符，最终可以得到B，交换的次数不限。比如：abc与bca就是同一类字符串。
 * 现在牛牛想知道这N个字符串可以分成几类。
 * 输入描述:
 * 首先输入一个正整数N（1 <= N <= 50），接下来输入N个字符串，每个字符串长度不超过50。
 * 输出描述:
 * 输出一个整数表示分类的个数。
 * 输入例子:
 * 4
 * abcd
 * abdc
 * dabc
 * bacd
 * 输出例子:
 * 1
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class StringClassification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//字符串的个数
        HashSet<String> set = new HashSet<>();
        while (N != 0) {
            char[] chs = sc.next().toCharArray();
            //排序
            Arrays.sort(chs);
            set.add(String.valueOf(chs));
            N--;
        }

        System.out.println(set.size());
    }
}
