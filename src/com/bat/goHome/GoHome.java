package com.bat.goHome;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/3.
 * 题目描述
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。
 * 现在他需要依次的从0号坐标走到N-1号坐标。
 * 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，
 * 问度度熊回家至少走多少距离？
 * <p>
 * 输入描述:
 * 输入一个正整数N, N <= 50。
 * 接下来N个整数表示坐标，正数表示X轴的正方向，负数表示X轴的负方向。绝对值小于等于100
 * <p>
 * 输出描述:
 * 输出一个整数表示度度熊最少需要走的距离。
 * <p>
 * 输入例子:
 * 4
 * 1 4 -1 3
 * <p>
 * 输出例子:
 * 4
 */
public class GoHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();//表示N个数

            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            int dis = 0;//最小的点到最大的点的距离
            for (int i = 1; i < N; i++) {
                dis += Math.abs(nums[i] - nums[i - 1]);
            }

            //所求的最小距离
            int minDis = dis;

            for (int i = 2; i < N; i++) {
                int temp = dis;
                int w = Math.abs(nums[i] - nums[i - 1]) +
                        Math.abs(nums[i - 1] - nums[i - 2]) -
                        Math.abs(nums[i] - nums[i - 2]);
                temp = temp - w;
                if (minDis > temp)
                    minDis = temp;
            }
            System.out.println(minDis);
        }
    }
}
