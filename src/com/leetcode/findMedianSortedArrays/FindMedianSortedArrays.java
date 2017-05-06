package com.leetcode.findMedianSortedArrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Feng on 2016/11/30.
 */
public class FindMedianSortedArrays {
    public static void main(String[] args) {
        int[] A = {};
        int[] B = {6, 7};
        double result = findMedianSortedArrays(A, B);
        System.out.println(result);
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        double result;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            list.add(A[i]);
        }
        for (int j = 0; j < n; j++) {
            list.add(B[j]);
        }

        Collections.sort(list);

        if (list.size() % 2 == 1) {
            result = list.get(list.size() / 2);
        } else {
            result = (double) (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) / 2;
        }
        return result;
    }
}
