package com.leetcode.divideTwoIntegers;

/**
 * Created by Feng on 2016/12/16.
 * <p>
 * Divide two integers without using multiplication, division and mod operator.
 * 思路：既然不能使用multiplication，division和mod，那么addition和subtraction operator还是可以用的。
 * 直接的思路是：除法本质上是减法，故可以迭代使用减法求解，同时计算迭代次数即为解，时间复杂度O(n)，超时。
 * 优化的思路：使用移位运算来求解。一个大数可以表示为num = a0*2^0 + a0 * 2^1 + …+ an * 2^n，
 * 看这个表达式应该就要想到一个求解的思路：每次将divisor左移位，直到达到小于dividend的最大整数A，
 * 此时左移次数为count,即达到an*2^n阶，商大于等于count，然后将dividend-A作为dividend，迭代运算，cout累加到商。
 */
public class DivideTwoIntegers {
    public static void main(String[] args) {
        int dividend = 100, divisor = 9;
        int result = divide(dividend, divisor);
        System.out.println("结果是: " + result);
    }

    public static int divide(int dividend, int divisor) {

        if (divisor == 0) {
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if (dividend == 0) {
            return 0;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);

        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int result = 0;
        while (a >= b) {
            int shift = 0;
            // 通过将除数乘2，乘4，乘8，一直乘下去，找到商的最高的次方
            while (a >= (b << shift)) {
                shift++;
            }
            a -= b << (shift - 1);
            result += 1 << (shift - 1);
        }
        return isNegative ? -result : result;
    }
}
