package com.huawei.studyEnglish;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/19.
 * 题目描述
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 * 如22：twenty two，123：one hundred and twenty three。
 * <p>
 * 说明：
 * 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 * 输出格式为twenty two；
 * 非法数据请返回“error”；
 * 关键字提示：and，billion，million，thousand，hundred。
 * <p>
 * 方法原型：public static String parse(long num)
 * <p>
 * 输入描述:
 * 输入一个long型整数
 * <p>
 * <p>
 * 输出描述:
 * 输出相应的英文写法
 * <p>
 * 输入例子:
 * 2356
 * <p>
 * 输出例子:
 * two thousand three hundred and fifty six
 */
public class StudyEnglish {

    static String[] englishNum = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static String[] englishEleven = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen",
            "seventeen", "eighteen", "nineteen"};
    static String[] englishTen = {"ten", "twenty", "thirty", "forty", "fifty",
            "sixty", "seventy", "eighty", "ninety"};
    static String[] bigNum = {"hundred", "thousand", "million", "billion"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long num = sc.nextLong();//输入一个long整数
            System.out.println(parse(num));
        }
    }

    public static String parse(long num) {
        if (num < 0) {
            return "error";
        }
        StringBuilder builder = new StringBuilder();
        long billion = num / 1000000000;//十亿
        if (billion != 0) {
            builder.append(translate(billion) + " " + bigNum[3] + " ");
        }

        num = num % 1000000000;
        long million = num / 1000000;//百万部分
        if (million != 0) {
            builder.append(translate(million) + " " + bigNum[2] + " ");
        }

        num = num % 1000000;
        long thousand = num / 1000;
        if (thousand != 0) {
            builder.append(translate(thousand) + " " + bigNum[1] + " ");
        }

        num = num % 1000;//百位

        if (num != 0) {
            builder.append(translate(num));
        }

        return builder.toString().trim();
    }

    public static String translate(long num) {
        StringBuilder builder = new StringBuilder();
        int h = (int) (num / 100);//百位处理
        if (h != 0) {
            builder.append(englishNum[h - 1] + " " + bigNum[0]);
        }

        num = num % 100;//十位部分

        long k = num / 10;
        if (k != 0) {
            if (h != 0) {//如果百位不等于0，要加and
                builder.append(" and ");

            }
            if (k == 1) {//若十位为1，连同个位一起翻译
                long t = num % 10;
                builder.append(englishEleven[(int) (t - 1)]);
            } else {//否则，十位和个位分别单独翻译
                builder.append(englishTen[(int) (k - 1)] + " ");
                if (num % 10 != 0) {
                    builder.append(englishNum[(int) (num % 10 - 1)]);
                }
            }
        } else if (num % 10 != 0) {
            //如果没有十位部分，直接翻译个位部分
            if (h != 0) {//如果百位不等于0，要加and
                builder.append(" and ");
            }
            builder.append(englishNum[(int) (num % 10 - 1)]);
        }

        return builder.toString().trim();
    }
}
