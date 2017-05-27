package com.swordOffer.numberOfOne23;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/27.
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13
 * 因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 */
public class NumberOfOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int inputNum = sc.nextInt();
            int result = numberOfOne(inputNum);
            System.out.println(result);
        }
    }

    private static int numberOfOne(int inputNum) {
        //统计1的个数
        int count = 0;
        //表示当前数字
        int curNum = 0;
        //表示低位
        int lowNum = 0;
        //表示高位
        int highNum = 0;
        //表示因子
        int factor = 1;

        while (inputNum / factor != 0) {
            // 12345对10取余，相当于将当前数置为个位
            curNum = (inputNum / factor) % 10;
            lowNum = inputNum % factor;
            highNum = inputNum / (factor * 10);

            //如果为0,出现1的次数由高位决定,等于高位数字 * 当前位数
            if (curNum == 0) {
                //表示10,101的情况
                count += factor * highNum;
            } else if (curNum == 1) {
                //如果为1,出现1的次数由高位和低位决定,高位*当前位+低位+1
                count += factor * highNum + lowNum + 1;
            } else {
                //如果大于1,出现1的次数由高位决定,
                //高位数字+1* 当前位数
                count += factor * (highNum + 1);
            }

            factor *= 10;

        }
        return count;
    }
}
