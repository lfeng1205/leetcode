package com.swordOffer.numberOfK29;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/5.
 * 统计一个数字在排序数组中出现的次数。
 */
public class NumberOfK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int target = sc.nextInt();
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            int result = getNumberOfK(nums, n, target);
            System.out.println(result);
        }
    }

    private static int getNumberOfK(int[] nums, int length, int k) {

        int number = 0;

        if (nums != null && length > 0) {
            int first = getFirstK(nums, length, k, 0, length - 1);
            int last = getLastK(nums, length, k, 0, length - 1);

            if (first > -1 && last > -1) {
                number = last - first + 1;
            }
        }

        return number;
    }

    private static int getFirstK(int[] nums, int length, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) >> 1;
        int middleNum = nums[middleIndex];

        //如果中间的数字等于k
        if (middleNum == k) {
            if ((middleIndex > 0 && nums[middleIndex - 1] != k)
                    || middleIndex == 0) {
                return middleIndex;
            } else {
                end = middleIndex - 1;
            }
            //如果中间的数字大于k，则在数组的前半段查找
        } else if (middleNum > k) {
            end = middleIndex - 1;
            //如果中间的数字小于k，则在数组的后半段查找
        } else {
            start = middleIndex + 1;
        }

        return getFirstK(nums, length, k, start, end);
    }

    private static int getLastK(int[] nums, int length, int k, int start, int end) {

        if (start > end) {
            return -1;
        }

        int middleIndex = (start + end) >> 1;
        int middleNum = nums[middleIndex];

        //如果中间的数字等于k
        if (middleNum == k) {
            if ((middleIndex < length - 1 && nums[middleIndex + 1] != k)
                    || middleIndex == length - 1) {
                return middleIndex;
            } else {
                start = middleIndex + 1;
            }
            //如果中间的数字小于k，则在数组的后半段查找
        } else if (middleNum < k) {
            start = middleIndex + 1;
            //如果中间的数字大于k，则在数组的前半段查找
        } else {
            end = middleIndex - 1;
        }

        return getLastK(nums, length, k, start, end);
    }
}
