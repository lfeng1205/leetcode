package com.bat.cutpaper;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/25.
 * 度度熊有一张网格纸，但是纸上有一些点过的点，每个点都在网格点上，若把网格看成一个坐标轴平行于网格线的坐标系的话，
 * 每个点可以用一对整数x，y来表示。度度熊必须沿着网格线画一个正方形，使所有点在正方形的内部或者边界。
 * 然后把这个正方形剪下来。问剪掉正方形的最小面积是多少。
 * 输入描述:
 * 第一行一个数n(2≤n≤1000)表示点数，接下来每行一对整数xi,yi(－1e9<=xi,yi<=1e9)表示网格上的点
 * 输出描述:
 * 一行输出最小面积
 * 输入例子:
 * 2
 * 0 0
 * 0 3
 * 输出例子:
 * 9
 */
public class CutPaper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//表示点数
            int[] X = new int[n];//存放Xi
            int[] Y = new int[n];//存放Yi

            int j = 0;

            int maxX = Integer.MIN_VALUE, minX = Integer.MAX_VALUE;
            int maxY = Integer.MIN_VALUE, minY = Integer.MAX_VALUE;

            for (int i = 0; i < 2 * n; i++) {
                if (i % 2 == 0) {//输入的事X坐标
                    X[j] = sc.nextInt();
                    if (maxX < X[j]) {
                        maxX = X[j];
                    }
                    if (minX > X[j]) {
                        minX = X[j];
                    }
                } else {//输入的是y坐标
                    Y[j] = sc.nextInt();
                    if (Y[j] > maxY) {
                        maxY = Y[j];
                    }
                    if (Y[j] < minY) {
                        minY = Y[j];
                    }
                    j++;
                }
            }

            int x = Math.abs(maxX - minX);
            int y = Math.abs(maxY - minY);

            if (x > y) {
                System.out.println(x * x);
            } else {
                System.out.println(y * y);
            }
        }
    }
}

