package com.bat.trianglesCount;

/**
 * Created by Feng on 2017/4/26.
 * 在100-999这900个自然数中,若将组成这个数的三个数字认为是三条线段的长度,
 * 那么是三条线段组成一个等腰三角形(包括等边)的共有()个
 */
public class TrianglesCount {
    public static void main(String[] args) {
        int count = 0;
        int a, b, c;
        for (int i = 100; i < 1000; i++) {
            //b或c不能为0
            if (i % 10 == 0 || i / 10 % 10 == 0) {
                continue;
            }

            //三角形三条边
            c = i % 10;
            b = i / 10 % 10;
            a = i / 100;

            //判断是否为等腰三角形包含等边三角形
            if (a == b || a == c || b == c) {
                if (a + b > c && a + c > b && b + c > a) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
