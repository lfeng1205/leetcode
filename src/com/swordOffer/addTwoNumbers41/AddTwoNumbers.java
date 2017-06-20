package com.swordOffer.addTwoNumbers41;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/20.
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int result = addTwoNumbers(num1, num2);
            System.out.println(result);
        }
    }

    private static int addTwoNumbers(int num1, int num2) {

        int sum, carry;//进位值
        do {
            //以5和17为例
            //第一步：相加各位的值，不算进位，得到10100，
            //二进制每位相加就相当于各位做异或操作，00101^10001。
            //第二步：计算进位值，得到00001，相当于各位做与操作得到00101&10001，
            // 再向左移一位得到00010,(00101 & 10001)<<1。
            //第三步重复上述两步,各位相加。
            //继续重复上述两步：直到进位值为0，跳出循环，10110为最终结果
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;

            num1 = sum;
            num2 = carry;
        } while (num2 != 0);
        return sum;
    }
}
