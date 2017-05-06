package com.bat.interestingSorting;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Feng on 2017/5/4.
 * 度度熊有一个N个数的数组，他想将数组从大到小排好序，但是萌萌的度度熊只会下面这个操作：
 * 任取数组中的一个数然后将它放置在数组的最后一个位置。
 * 问最少操作多少次可以使得数组从小到大有序？
 * 输入描述:
 * 首先输入一个正整数N，接下来的一行输入N个整数。(N <= 50, 每个数的绝对值小于等于1000)
 * <p>
 * 输出描述:
 * 输出一个整数表示最少的操作次数。
 * <p>
 * 输入例子:
 * 4
 * 19 7 8 25
 * <p>
 * 输出例子:
 * 2
 */
public class InterestingSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();//数组的大小
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            //新建一个数组，用来存放数
            int[] temp = Arrays.copyOf(nums, N);

            //对新数组进行排序
            Arrays.sort(temp);

            int q = -1;
            for (int i = 0; i < N; i++) {
                //找原序列可以作为排序后序列前缀序列的长度,然后用N减掉这部分长度
                if (nums[i] == temp[q + 1]) {
                    q++;
                    if (q == N - 1) {
                        break;
                    }
                }
            }

            System.out.println(N - q - 1);
        }

    }
}
