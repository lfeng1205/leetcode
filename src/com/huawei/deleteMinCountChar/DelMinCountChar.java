package com.huawei.deleteMinCountChar;

import java.util.*;

/**
 * Created by Feng on 2017/2/26.
 * 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。
 * 输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 * 输入例子：
 *
 * abcdd
 * 输出例子：
 * dd
 */
public class DelMinCountChar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.nextLine();
            char[] s = str.toCharArray();
            int[] hash = new int[128];

            for (int i = 0; i < s.length; i++) {
                hash[s[i]]++;
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] != 0 && hash[i] < min) {
                    min = hash[i];
                }
            }

            StringBuffer res = new StringBuffer();
            for (int i = 0; i < s.length; i++) {
                if (hash[s[i]] != min) {
                    res.append(s[i]);
                }
            }
            System.out.println(res);
        }
    }
}
