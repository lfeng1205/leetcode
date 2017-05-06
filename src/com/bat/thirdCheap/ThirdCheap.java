package com.bat.thirdCheap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Feng on 2017/4/27.
 * 题目描述
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。
 * 度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * <p>
 * 输入描述:
 * 首先输入一个正整数N（N <= 50），接下来输入N个数表示每顶帽子的价格（价格均是正整数，且小于等于1000）
 * <p>
 * 输出描述:
 * 如果存在第三便宜的帽子，请输出这个价格是多少，否则输出-1
 * <p>
 * 输入例子:
 * 10
 * 10 10 10 10 20 20 30 30 40 40
 * <p>
 * 输出例子:
 * 30
 */
public class ThirdCheap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//正整数
            int[] prices = new int[n];//n个价格
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();
            }

            Arrays.sort(prices);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!list.contains(prices[i])) {
                    list.add(prices[i]);
                }
            }

            if (list.size() < 3) {
                System.out.println(-1);
            } else {
                System.out.println(list.get(2));
            }

        }
    }
}
