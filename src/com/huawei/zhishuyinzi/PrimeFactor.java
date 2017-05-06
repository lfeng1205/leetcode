package com.huawei.zhishuyinzi;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/17.
 * 题目描述
 * 功能:输入一个正整数，按照从小到大的顺序输出它的所有质数的因子（如180的质数因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 * 详细描述：
 * 函数接口说明：
 * public String getResult(long ulDataInput)
 * 输入参数：
 * long ulDataInput：输入的正整数
 * 返回值：
 * String
 * 输入描述:
 * 输入一个long型整数
 * 输出描述:
 * 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。
 * 输入例子:
 * 180
 * 输出例子:
 * 2 2 3 3 5
 */
public class PrimeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long inputNum = sc.nextLong();
        if (inputNum < 2) {
            sc.close();
            return;
        }

        String result = primeFactor(inputNum);
        System.out.println(result);
        sc.close();
    }

    public static String primeFactor(long inputNum) {
        //用来存储输出的字符串
        StringBuilder builder = new StringBuilder();
        int index = 2;
        while (index <= inputNum) {
            if (inputNum % index == 0) {
                if (index == inputNum) {
                    builder.append(index).append(" ");
                    break;
                } else {
                    builder.append(index).append(" ");
                    inputNum = inputNum / index;
                }
            } else {
                index++;
            }

        }

        return builder.toString();
    }

}
