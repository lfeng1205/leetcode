package com.swordOffer.continousCards37;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Feng on 2017/6/15.
 * 题目描述
 * 从扑克牌中随机抽出5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2~10为数字本身，A为1，j为11，Q为12，K为13，而大小王可以看成是任意
 * 数字。
 */
public class ContinousCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //数组的大小
            int length = sc.nextInt();

            int[] cards = new int[length];
            for (int i = 0; i < length; i++) {
                cards[i] = sc.nextInt();
            }
            boolean reult = isContinuous(cards);
            System.out.println(reult);
        }
    }

    private static boolean isContinuous(int[] cards) {
        if (cards == null || cards.length < 1) {
            return false;
        }

        //对数组排序
        Arrays.sort(cards);

        int numberOfZero = 0;//0的个数
        int index = 0;

        //统计数组中0的个数
        for (; index < cards.length && cards[index] == 0; index++) {
            numberOfZero++;
        }

        for (; index < cards.length - 1 && numberOfZero >= 0; index++) {
            if (cards[index] == cards[index + 1]) {
                //有对子不可能是顺子
                return false;
            } else if (cards[index] + 1 + numberOfZero >= cards[index + 1]) {
                //可以继续匹配
                numberOfZero -= cards[index + 1] - cards[index] - 1;
            } else {
                return false;
            }
        }

        if (index == cards.length - 1) {
            return true;
        } else {
            return false;
        }
    }
}
