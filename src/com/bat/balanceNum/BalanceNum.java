package com.bat.balanceNum;


/**
 * Created by Feng on 2017/4/11.
 * 牛牛在研究他自己独创的平衡数，平衡数的定义是：将一个数分成左右两部分，分别成为两个新的数。
 * 左右部分必须满足以下两点：
 * 1，左边和右边至少存在一位。
 * 2，左边的数每一位相乘如果等于右边的数每一位相乘，则这个数称为平衡数。
 * 例如：1221这个数，分成12和21的话，1*2=2*1，则称1221为平衡数，再例如：1236这个数，
 * 可以分成123和1*2*3=6，所以1236也是平衡数。而1234无论怎样分也不满足平衡数。
 * 输入描述:
 * 输入一个正整数（int范围内）。
 * 输出描述:
 * 如果该数是平衡数，输出 "YES", 否则输出 "NO"。
 * 输入例子:
 * 1221
 * 1234
 * 输出例子:
 * YES
 * NO
 */

import java.util.Scanner;

public class BalanceNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String numStr = sc.nextLine();
            if (numStr.length() < 2) {
                System.out.println("NO");
            } else {
                boolean isBalanceNum = false;
                for (int i = 1; i < numStr.length(); i++) {
                    //将数字分为左右两部分
                    String left = numStr.substring(0, i);
                    String right = numStr.substring(i);

                    //左边部分的第一个数字
                    int leftVal = Integer.parseInt(left.substring(0, 1));
                    //右边部分的第一个数字
                    int rightVal = Integer.parseInt(right.substring(0, 1));

                    //计算左边部分的乘积
                    for (int j = 1; j < left.length(); j++) {
                        leftVal *= Integer.parseInt(left.substring(j, j + 1));
                    }

                    //计算右边部分的乘积
                    for (int j = 1; j < right.length(); j++) {
                        rightVal *= Integer.parseInt(right.substring(j, j + 1));
                    }

                    //判断左右是否相等
                    if (leftVal == rightVal) {
                        isBalanceNum = true;
                        break;
                    }
                }

                System.out.println(isBalanceNum ? "YES" : "NO");
            }
        }
    }
}
