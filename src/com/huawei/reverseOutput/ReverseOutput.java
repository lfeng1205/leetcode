package com.huawei.reverseOutput;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/1.
 */
public class ReverseOutput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int inputNum = sc.nextInt();
            String s = String.valueOf(inputNum);
            char[] chs = s.toCharArray();
            String str = "";

            for (int i = s.length() - 1; i >= 0; i--) {
                str = str + chs[i];
            }

            System.out.println(str);
        }
    }
}
