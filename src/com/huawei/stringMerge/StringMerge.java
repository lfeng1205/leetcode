package com.huawei.stringMerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Feng on 2017/3/4.
 * 题目描述
 * 按照指定规则对输入的字符串进行处理。
 * 详细描述：
 * 将输入的两个字符串合并。
 * 对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。
 * 这里的下标意思是字符在字符串中的位置。
 * 对排序后的字符串进行操作，如果字符为‘0’——‘9’或者‘A’——‘F’或者‘a’——‘f’，
 * 则对他们所代表的16进制的数进行BIT倒序的操作，并转换为相应的大写字符。
 * 如字符为‘4’，为0100b，则翻转后为0010b，也就是2。转换后的字符为‘2’； 如字符为‘7’，为0111b，
 * 则翻转后为1110b，也就是e。转换后的字符为大写‘E’。
 * <p>
 * 举例：输入str1为"dec"，str2为"fab"，合并为“decfab”，分别对“dca”和“efb”进行排序，
 * 排序后为“abcedf”，转换后为“5D37BF”
 * 接口设计及说明：
 * /*
 * 功能:字符串处理
 * 输入:两个字符串,需要异常处理
 * 输出:合并处理后的字符串，具体要求参考文档
 * 返回:无
 * <p>
 * 输入描述:
 * 输入两个字符串
 * <p>
 * <p>
 * 输出描述:
 * 输出转化后的结果
 * <p>
 * 输入例子:
 * dec fab
 * <p>
 * 输出例子:
 * 5D37BF
 */

public class StringMerge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            str += sc.next();
            System.out.println(reverseString(sort(str)));
        }
    }

    public static String reverseString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chs = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char ch : chs) {
            if ((ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F') || (ch >= '0' && ch <= '9')) {
                //将16进制的数字数字转为2进制
                String bStr = "0000" + Integer.toBinaryString(Integer.valueOf(ch + "", 16));
                //截取字符串
                bStr = bStr.substring(bStr.length() - 4);
                String oXStr = "";
                for (int i = bStr.length() - 1; i >= 0; i--) {
                    oXStr += bStr.charAt(i);
                }

                //将2进制的数字转为16进制
                String res = Integer.toHexString(Integer.parseInt(oXStr, 2)).toUpperCase();
                builder.append(res);
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }

    public static String sort(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] nums = str.toCharArray();

//        for (int k = 0; k < 2; k++) {
//            for (int i = k + 2; i < nums.length; i += 2) {
//                int j = i - 2;
//                char key = nums[i];
//                while (j >= 0 && key < nums[j]) {
//                    nums[j + 2] = nums[j];
//                    j -= 2;
//                }
//                nums[j + 2] = key;
//            }
//        }

        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                list1.add(nums[i]);
            } else {
                list2.add(nums[i]);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        String res = "";
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                list.add(list1.get(i / 2));
            } else {
                list.add(list2.get((i - 1) / 2));
            }
        }

        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
        }
        return res;

        //return new String(nums);
    }
}
