package com.huawei.snakeMatrix;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/8.
 */
public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //矩阵行数
            int n = sc.nextInt();
            System.out.println(snakeMatrix(n));
        }
        sc.close();
    }

    public static String snakeMatrix(int n) {
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            //step为间隔
            int step = i + 1;

            //start为每行第一个数
            int start = (i - 1) * i / 2 + 1;
            //j为每行元素个数
            for (int j = 1; j <= n - i + 1; j++) {
                builder.append(start).append(' ');
                start = start + step;
                step++;
            }
            //设置换行符
            builder.setCharAt(builder.length() - 1, '\n');
        }

        return builder.toString();
    }
}
