package com.leetcode.threeSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Feng on 2016/12/22.
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] num = {-1, 0, 1, 2, -1, -4};
        ArrayList<ArrayList<Integer>> result = threeSum(num);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (num == null || num.length < 3) {
            return arrayList;
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length - 2; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue; // to skip duplicate numbers; e.g [0,0,0,0]
            }

            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(num[i]);
                    list.add(num[left]);
                    list.add(num[right]);
                    arrayList.add(list);
                    left++;
                    right--;
                    while (left < right && num[left] == num[left - 1]) {// to skip duplicates
                        left++;
                    }
                    while (left < right && num[right] == num[right + 1]) {// to skip duplicates
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return arrayList;
    }
}
