package com.bat.highestScore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Feng on 2017/2/21.
 * 题目描述
 * 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 * 输入描述:
 * 输入包括多组测试数据。
 * 每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 * 学生ID编号从1编到N。
 * 第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 * 接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候,
 * 表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 * 当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 * <p>
 * <p>
 * 输出描述:
 * 对于每一次询问操作，在一行里面输出最高成绩.
 * <p>
 * 输入例子:
 * 5 7
 * 1 2 3 4 5
 * Q 1 5
 * U 3 6
 * Q 3 4
 * Q 4 5
 * U 4 5
 * U 2 9
 * Q 1 5
 * <p>
 * 输出例子:
 * 5
 * 6
 * 5
 * 9
 */
public class HighestScore {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringTokenizer st;
        while ((line = reader.readLine()) != null) {
            st = new StringTokenizer(line);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //获取初始化成绩
            int[] score = new int[N + 1];
            if ((line = reader.readLine()) != null) {
                st = new StringTokenizer(line);
                for (int i = 1; i <= N; i++) {
                    score[i] = Integer.parseInt(st.nextToken());
                }
            }

            //进行Q U操作
            for (int i = 0; i < M; i++) {
                if ((line = reader.readLine()) != null) {
                    st = new StringTokenizer(line);
                    String method = st.nextToken();
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    if (method.equals("Q")) {
                        System.out.println(max(a, b, score));
                    } else {
                        score[a] = b;
                    }
                }
            }
        }
    }

    public static int max(int start, int end, int[] students) {
        if (start > end) {
            return max(end, start, students);
        } else {
            int max = students[start];
            for (int i = start + 1; i <= end; i++) {
                if (students[i] > max) {
                    max = students[i];
                }
            }

            return max;
        }

    }

}
