package com.bat.continuousInteger;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Feng on 2017/3/20.
 * 牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。
 * 牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
 * 10 7 12 8 11 那么抹除掉的整数只可能是9
 * 5 6 7 8 那么抹除掉的整数可能是4也可能是9
 * <p>
 * 输入描述:
 * 输入包括2行：
 * <p>
 * 第一行为整数n(1 <= n <= 50)，即抹除一个数之后剩下的数字个数
 * <p>
 * 第二行为n个整数num[i] (1 <= num[i] <= 1000000000)
 * <p>
 * <p>
 * 输出描述:
 * 在一行中输出所有可能是抹除掉的数,从小到大输出,用空格分割,行末无空格。如果没有可能的数，则输出mistake
 * <p>
 * 输入例子:
 * 2
 * 3 6
 * <p>
 * 输出例子:
 * mistake
 */
public class ContinuousInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//输入整数n(1 <= n <= 50)，即抹除一个数之后剩下的数字个数
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();//输入n个整数num[i] (1 <= num[i] <= 1000000000)
        }

        Arrays.sort(num);//对数组中的数字进行排序

        if (n == 1) {//特殊情况
            if (num[0] == 1) {
                System.out.println(num[0] + 1);
            } else {
                System.out.println((num[0] - 1) + " " + (num[0] + 1));
            }
        } else {
            if (num[n - 1] - num[0] == n) {//有一个间隔的情况
                for (int i = 0; i < n - 1; i++) {
                    if (num[i + 1] - num[i] == 2) {
                        System.out.println(num[i] + 1);
                    } else if (num[i + 1] - num[i] > 2) {
                        System.out.println("mistake");
                    }
                }
            } else if (num[n - 1] - num[0] > n) {//有2个及以上间隔数的情况
                System.out.println("mistake");
            } else {
                //没有间隔的情况
                if (num[0] == 1) {
                    System.out.println(num[n - 1] + 1);
                } else {
                    System.out.println((num[0] - 1) + " " + (num[n - 1] + 1));
                }
            }
        }
    }
}
