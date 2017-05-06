package com.leetcode.threeSumClosest;

import java.util.Arrays;

/**
 * Created by Feng on 2016/12/25.
 * Given an array S of n integers, find three integers in S such that the sum
 * is closest to a given number, target. Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] num = {1, 1, 1, 0, 1, 1};
        int result = threeSumClosest(num, 100);
        System.out.println("结果是： " + result);
    }


    public static int threeSumClosest(int[] num, int target) {
        if (num == null || num.length < 3) {
            return 0;
        }

        Arrays.sort(num);
        int closestDist = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {//跳过重复的数字,例如[1,1,1,1,1,1,1]
                continue;
            }

            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum < target) {
                    if (target - sum < closestDist) {
                        closestDist = target - sum;
                        res = sum;
                    }
                    left++;
                } else if (sum > target) {
                    if (sum - target < closestDist) {
                        closestDist = sum - target;
                        res = sum;
                    }
                    right--;
                } else {
                    return sum;
                }

            }
        }
        return res;
    }
}
