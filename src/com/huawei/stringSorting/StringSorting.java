package com.huawei.stringSorting;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/28.
 * <p>
 * 编写一个程序，将输入字符串中的字符按如下规则排序。规则1：英文字母从A到Z排列，不区分大小写。     
 * 如，输入：Type 输出：epTy规则2：同一个英文字母的大小写同时存在时，按照输入顺序排列。    
 * 如，输入：BabA 输出：aABb规则3：非英文字母的其它字符保持原来的位置。   
 * 如，输入：By?e 输出：Be?y样例：    
 * 输入：   A Famous Saying: Much Ado About Nothing(2012/8).    
 * 输出：   A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
 */
public class StringSorting {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int len = str.length();
            char[] chs = str.toCharArray();
            char[] tmp = new char[len];
            int k = 0;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < len; j++) {
                    if (chs[j] - 'a' == i || chs[j] - 'A' == i) {
                        tmp[k++] = chs[j];
                    }
                }
            }

            k = 0;
            for (int i = 0; i < len; i++) {
                if (chs[i] >= 'a' && chs[i] <= 'z' || chs[i] >= 'A' && chs[i] <= 'Z') {
                    chs[i] = tmp[k++];
                }
            }

            System.out.println(String.valueOf(chs));
        }
    }

}
