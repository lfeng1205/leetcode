package com.swordOffer.greatestSumOfSubarrays22;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/23.
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。
 * 今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},
 * 连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class GreatestSumOfSubarrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = sc.nextInt();
            }

            int result = findGreatestSumOfSubarrays(input, n);
            System.out.println(result);
        }
    }

    private static int findGreatestSumOfSubarrays(int[] input, int nLength) {
        if (input == null || nLength <= 0) {
            return 0;
        }

        int nGreatestSum = Integer.MIN_VALUE;
        int nCurSum = 0;
        for (int i = 0; i < nLength; i++) {

            //如果小于0，则舍弃
            if (nCurSum <= 0) {
                nCurSum = input[i];
            } else {//否则就继续累加
                nCurSum += input[i];
            }

            //不断进行比较，找到最大的值
            if (nCurSum > nGreatestSum) {
                nGreatestSum = nCurSum;
            }
        }

        return nGreatestSum;
    }
}
