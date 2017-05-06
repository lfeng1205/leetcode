package com.huawei.jinsizhi;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/19.
 * 题目描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。
 * 如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
 * <p>
 * 输入描述:
 * 输入一个正浮点数值
 * <p>
 * 输出描述:
 * 输出该数值的近似整数值
 * <p>
 * 输入例子:
 * 5.5
 * <p>
 * 输出例子:
 * 6
 */
public class Approximation {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        float inputNum = sc.nextFloat();
//        int result = Math.round(inputNum);
//        System.out.println(result);
        int result = round(inputNum);
        System.out.println(result);
    }

    public static int round(float inputNum) {
        int num = (int) (inputNum);
        float num2 = inputNum - num;
        if (num2 >= 0.5) {
            return num + 1;
        } else {
            return num;
        }
    }

}
