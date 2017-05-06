package com.leetcode.fourSum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Feng on 2016/12/26.
 */
public class FourSum {
    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        ArrayList<ArrayList<Integer>> result = fourSum(num, 0);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        if (num == null || num.length < 4) {
            return arrayList;
        }

        Arrays.sort(num);

        for (int i = 0; i < num.length - 3; i++) {
            if (i != 0 && num[i] == num[i - 1]) {
                continue;
            }

            int begin = i + 1;
            int threeSum = target - num[i];
            for (int j = begin; j < num.length - 2; j++) {
                if (j != begin && num[j] == num[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = num.length - 1;
                while (left < right) {
                    int sum = num[j] + num[left] + num[right];
                    if (sum == threeSum) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(num[i]);
                        list.add(num[j]);
                        list.add(num[left]);
                        list.add(num[right]);
                        arrayList.add(list);
                        left++;
                        right--;
                        while (left < right && num[left] == num[left - 1]) {
                            left++;
                        }
                        while (left < right && num[right] == num[right + 1]) {
                            right--;
                        }
                    } else if (sum < threeSum) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return arrayList;
    }
}
