package com.swordOffer.arrayConstruction44;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/21.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 数组B可以看成是一个主对角线是1的矩阵，B[i]即为第i行的乘积
 * 不能使用除法。
 * 基本思路：
 * 可以把B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]看成是
 * A[0]*A[1]*...*A[i-1]和A[i+1]*...*A[n-2]*A[n-1]两部分的乘积。
 * 定义C[i]=A[0]*A[1]*...*A[i-1]，D[i]=A[i+1]*...*A[n-2]*A[n-1]
 * C[i]=C[i-1]*A[i-1](C[0]=1)，D[i]=D[i+1]*A[i+1](D[0]=1)
 * B[i]=C[i]*D[length-i-1](从后往前计算)
 */
public class ArrayContruction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            int[] result = arrayContruction(A);
            for (int i = 0; i < n; i++) {
                if (i == n - 1) {
                    System.out.print(result[i] + " ");
                } else {
                    System.out.print(result[i] + " ");
                }
            }
        }
    }

    private static int[] arrayContruction(int[] A) {

        if (A == null || A.length == 0) {
            return new int[1];
        }

        int length = A.length;
        int[] pre = new int[length];
        int[] back = new int[length];
        int[] B = new int[length];

        pre[0] = 1;
        back[0] = 1;

        for (int i = 1; i < length; i++) {
            //从左到右计算乘积
            pre[i] = A[i - 1] * pre[i - 1];
            //从右到左计算乘积
            back[i] = A[length - i] * back[i - 1];
        }

        for (int i = 0; i < length; i++) {
            B[i] = pre[i] * back[length - i - 1];
        }
        return B;
    }
}
