package com.huawei.wordDown;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/5.
 * 题目描述
 * 对字符串中的所有单词进行倒排。
 * 说明：
 * 1、每个单词是以26个大写或小写英文字母构成；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，
 * 倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 * <p>
 * 输入描述:
 * 输入一行以空格来分隔的句子
 * <p>
 * <p>
 * 输出描述:
 * 输出句子的逆序
 * <p>
 * 输入例子:
 * I am a student
 * <p>
 * 输出例子:
 * student a am I
 */
public class WordDown {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            if (str == null) {
                return;
            }
//            String[] strArray = str.split("[^a-zA-Z]+");
//            for (int i = strArray.length - 1; i >= 2; i--) {
//                System.out.print(strArray[i] + ' ');
//            }
//            if (strArray[0].length() == 0)//如果字符串数组的第一个元素是空串，
//                // 那么下标为1的元素就是最后一个要输出的元素，末尾不要再加空格
//                System.out.println(strArray[1]);
//            else
//                System.out.println(strArray[1] + ' ' + strArray[0]);

            char[] chs = str.toCharArray();
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] >= 'a' && chs[i] >= 'a' || chs[i] >= 'A' && chs[i] <= 'Z' || chs[i] == ' ') {
                    //将字母添加到buffer
                    buffer.append(chs[i]);
                } else {
                    //将非字母字符替换为空格
                    buffer.append(' ');
                }
            }

            String[] strs = buffer.toString().split(" ");
            StringBuffer sBuffer = new StringBuffer();
            for (int i = strs.length - 1; i >= 0; i--) {
                sBuffer = sBuffer.append(strs[i] + " ");
            }

            String res = new String(sBuffer);
            res = res.trim();//trim()是去两边空格的方法把StringBuffer转换成String类型
            System.out.println(res);
        }
    }
}
