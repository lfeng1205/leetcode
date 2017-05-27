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

            //如果当前位数字为0的话，那么他完全由高位的数字决定
            //比如12013，百位数字为1，那么百位上数字为1的仅仅是12*100个
            if (curNum == 0) {
                //表示10,101的情况
                count += factor * highNum;
            } else if (curNum == 1) {
                //这个1是100,1000整的时候
                count += factor * highNum + lowNum + 1;
            } else {
                //这个就不用加1了，因为在1*factor中包括了100,1000的情况
                count += factor * (highNum + 1);
            }

            factor *= 10;

        }
        return count;
    }
}
