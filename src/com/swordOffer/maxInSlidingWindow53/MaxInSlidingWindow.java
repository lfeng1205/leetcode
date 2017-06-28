package com.swordOffer.maxInSlidingWindow53;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Feng on 2017/6/28.
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}，
 * {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInSlidingWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }
            int size = sc.nextInt();

            ArrayList<Integer> arrayList = maxInWindow(num, size);
            System.out.println(arrayList);
        }
    }

    private static ArrayList<Integer> maxInWindow(int[] num, int size) {

        ArrayList<Integer> list = new ArrayList<>();
        if (num.length == 0 || size <= 0) {
            return list;
        }

        for (int i = 0; i < num.length - size; i++) {//有多少个滑动窗口
            int max = 0;//每个滑动窗口的最大值
            for (int j = i; j < i + size; j++) {
                if (max < num[j]) {
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }
}
