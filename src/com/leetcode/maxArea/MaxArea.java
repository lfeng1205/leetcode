package com.leetcode.maxArea;

/**
 * Created by Feng on 2016/12/19.
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains
 * the most water.
 * Note: You may not slant the container.
 * 思路：
 * x轴上在1,2,...,n点上有许多垂直的线段，长度依次是a1, a2, ..., an。找出两条线段，使他们和x抽围成的面积最大。
 * i,j分别指向开始和末尾，比较height[i]和height[j]，如果height[i]<height[j]，则i++；反之，j--；
 * 针对每个位置求出maxArea，如果比当前最大值大则更新max。
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] height = {2, 5, 6, 8, 4, 9, 11, 7};
        int result = maxArea(height);
        System.out.println("结果是：" + result);
    }

    public static int maxArea(int[] height) {

        if (height == null || height.length == 0) {
            return 0;
        }

        int i = 0, j = height.length - 1, maxArea = 0, area = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                area = (j - i) * (height[i]);
                i++;
            } else {
                area = (j - i) * (height[j]);
                j--;
            }

            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
}
