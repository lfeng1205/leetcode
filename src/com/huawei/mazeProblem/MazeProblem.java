package com.huawei.mazeProblem;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/22.
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
 * <p>
 * int maze[5][5] = {
 * <p>
 * 0, 1, 0, 0, 0,
 * <p>
 * 0, 1, 0, 1, 0,
 * <p>
 * 0, 0, 0, 0, 0,
 * <p>
 * 0, 1, 1, 1, 0,
 * <p>
 * 0, 0, 0, 1, 0,
 * <p>
 * };
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
 * Input
 * 一个N × M的二维数组，表示一个迷宫。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * Output
 * 左上角到右下角的最短路径，格式如样例所示。
 * Sample Input
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * Sample Output
 * (0, 0)
 * (1, 0)
 * (2, 0)
 * (2, 1)
 * (2, 2)
 * (2, 3)
 * (2, 4)
 * (3, 4)
 * (4, 4)
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。
 * 数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * <p>
 * <p>
 * 输出描述:
 * 左上角到右下角的最短路径，格式如样例所示。
 * <p>
 * 输入例子:
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * <p>
 * 输出例子:
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 */
public class MazeProblem {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String q = s.nextLine();
            String[] q1 = q.split(" ");
            int n = Integer.valueOf(q1[0]);//行数
            int m = Integer.valueOf(q1[1]);//列数
            int[][] arr = new int[n][m];
            boolean[][] b = new boolean[n][m];
            b[n - 1][m - 1] = true;

            for (int i = 0; i < n; i++) {
                String w = s.nextLine();
                String[] r = w.split(" ");
                for (int j = 0; j < r.length; j++)
                    arr[i][j] = Integer.valueOf(r[j]);
            }

            haspath(arr, b, 0, 0, n, m);
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b[0].length; j++) {
                    if (b[i][j]) {
                        System.out.println("(" + i + "," + j + ")");
                    }
                }
            }

        }
    }


    public static boolean haspath(int[][] arr, boolean[][] b, int n, int m, int nlength, int mlength) {
        boolean flag = false;
        if (n == nlength - 2 && m == mlength - 1 && arr[n][m] == 0) {
            //如果数组是两行一列
            b[n][m] = true;
            return true;
        }
        if (m == mlength - 2 && n == nlength - 1 && arr[n][m] == 0) {
            //如果数组是一行两列
            b[n][m] = true;
            return true;
        } else if (m >= mlength || n >= nlength) {
            return false;
        } else if (arr[n][m] == 0 && !b[n][m]) {
            b[n][m] = true;
            flag = haspath(arr, b, n + 1, m, nlength, mlength) ||
                    haspath(arr, b, n, m + 1, nlength, mlength);
        }
        if (flag) {
            return flag;
        } else {
            b[n][m] = false;
            return false;
        }
    }
}
