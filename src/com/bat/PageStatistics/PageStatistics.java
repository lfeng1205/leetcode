package com.bat.PageStatistics;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/20.
 * 牛牛新买了一本算法书，算法书一共有n页，页码从1到n。牛牛于是想了一个算法题目：
 * 在这本算法书页码中0~9每个数字分别出现了多少次？
 * 输入描述:
 * 输入包括一个整数n(1 ≤ n ≤ 1,000,000,000)
 * <p>
 * <p>
 * 输出描述:
 * 输出包括一行10个整数，即0~9这些数字在页码中出现的次数，以空格分隔。行末无空格。
 * <p>
 * 输入例子:
 * 999
 * <p>
 * 输出例子:
 * 189 300 300 300 300 300 300 300 300 300
 */
public class PageStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();//输入总页数
            int[] res = count(n);

            for (int i = 0; i < res.length; i++) {
                if (i == res.length - 1) {
                    System.out.print(res[i]);
                } else {
                    System.out.print(res[i] + " ");
                }
            }
        }
    }

    public static int pageStatistics(int n, int i) {
        int iCount = 0;//统计i位数字出现的次数
        int iFactor = 1;//因子
        int iLowerNum = 0;//记录第i位之下的低位
        int iCurrNum = 0;//现在的所处位置的数字
        int iHigherNum = 0;//记录第i位之下的高位

        while (n / iFactor != 0) {
            iLowerNum = n - (n / iFactor) * iFactor;//第i位之下的低位数字
            iCurrNum = (n / iFactor) % 10;//现在的所处位置的数字
            iHigherNum = n / (iFactor * 10);//第i位之上的高位数字

            if (iCurrNum < i) {
                iCount += iHigherNum * iFactor;
            } else if (i == iCurrNum) {
                iCount += iHigherNum * iFactor + iLowerNum + 1;
            } else if (iCurrNum > i) {
                iCount += (iHigherNum + 1) * iFactor;
            }

            //处理0的个数
            //若n为1位数，比如本来是1 2 3 4 5 6 ，之前处理成 0 1 2 3 4 5 6,多加了1个0
            //若n为2位数，比如本来是1 2 3 4 5 6 7 8 9 10 11 12，之前处理成 00 01 02 ...09 10 11 12,
            // 多加了1+10个0
            //若n为3位数，比如本来是1 2 3 4 ... 115，之前处理成000 001 002 ...009 010 011...099 100...115，
            // 多加了1+10+100个0
            //因此需要在每层循环中减去多计算的0的个数

            if (0 == i) {
                iCount -= iFactor;
            }

            iFactor *= 10;
        }

        return iCount;
    }

    public static int[] count(int n) {//依次统计0~9
        int[] res = new int[10];
        for (int i = 0; i < 10; i++) {
            res[i] += pageStatistics(n, i);
        }

        return res;
    }
}
