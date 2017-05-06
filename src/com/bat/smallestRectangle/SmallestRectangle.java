package com.bat.smallestRectangle;


/**
 * Created by Feng on 2017/4/11.
 * 牛牛在二维坐标系中画了N个点，且都是整点。现在牛牛想画出一个矩形，使得这N个点都在矩形内或者在矩形上。
 * 矩形的边均平行于坐标轴。牛牛希望矩形的面积最小。请你帮助牛牛计算下最小矩形的面积。
 * 输入描述:
 * 首先输入一个正整数N表示点的个数（2 <= N <= 50）
 * 接下来N行每行两个整数x, y，表示该点的坐标。绝对值均小于等于100.
 * 输出描述:
 * 一个整数表示最小矩形的面积。
 * 输入例子:
 * 2
 * 0 1
 * 1 0
 * 输出例子:
 * 1
 */

import java.util.Scanner;

public class SmallestRectangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();//表示点的个数

        int[] x = new int[N];
        int[] y = new int[N];

        int j = 0;

        int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;
        for (int i = 0; i < 2 * N; i++) {

            if (i % 2 == 0) {//输入的是x坐标
                x[j] = sc.nextInt();
                if (maxX < x[j]) {
                    maxX = x[j];
                }
                if (minX > x[j]) {
                    minX = x[j];
                }
            } else {//输入的是y坐标
                y[j] = sc.nextInt();
                if (y[j] > maxY) {
                    maxY = y[j];
                }
                if (y[j] < minY) {
                    minY = y[j];
                }
                j++;
            }
        }

        System.out.println(Math.abs(maxX - minX) * Math.abs(maxY - minY));
    }
}
