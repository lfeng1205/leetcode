package com.swordOffer.accumulate40;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/20.
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 */
public class Accumulate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            //int result = getSum(n);
            int result = getSum2(n);
            System.out.println(result);
        }
    }

    private static int getSum(int n) {

        int sum = n;
        //利用&&短路的原理，如果ans=(n>0)为true则计算右面
        //如果ans=(n>0)为false，则返回结果
        boolean ans = (n > 0) && (sum += getSum(n - 1)) > 0;
        return sum;
    }

    private static int getSum2(int n) {

        int sum = (int) (Math.pow(n, 2) + n);
        return sum >> 1;
    }
}
