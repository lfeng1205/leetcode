package com.bat.arraySum;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/10.
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。
 * 答案可能有多个，我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 */
public class ArraySum {
    public static void main(String[] args) {
        //读取输入
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int l = Integer.parseInt(line.split(" ")[1]);
        //最短长度
        int minLength = l;
        //最小起点,可以从0开始
        int minStart = n / 100 - 50 >= 0 ? n / 100 - 50 : 0;
        //长度不能超过100
        while (minLength <= 100) {
            int sum = 0;
            //每当长度增长的时候，重新计算可能的最小起始值，可以从 0 开始
            int currentStart = n / minLength - minLength / 2 >= 0 ? n / minLength - minLength / 2 : 0;
            //起始值绝对不会超过最小长度个数的平均值
            for (int start = currentStart; start <= n / minLength; start++) {
                int length = minLength;
                int tag = 0;//记录相加的个数
                sum = 0;
                while (length > 0 && sum < n) {
                    sum += start + tag;//被加数每次需要+1，表示下一个被加的数
                    tag++;
                    length--;
                }
                if (sum == n && tag >= l) {//若求和相等并且长度在题目范围之内
                    minStart = start;
                    break;//第一次的长度就是最短长度了
                } else if (sum > n) {
                    continue;
                }
            }

            if (sum == n) {
                break;
            }
            minLength++;
        }

        //输出信息
        if (minLength > 100) {
            System.out.println("No");
        } else {
            for (int i = minStart; minLength-- > 0; i++) {
                System.out.print(i);
                if (minLength != 0) {
                    System.out.print(" ");
                }
            }
        }
    }
}
