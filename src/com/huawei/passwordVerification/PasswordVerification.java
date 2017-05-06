package com.huawei.passwordVerification;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/25.
 * 密码要求:
 * 1.长度超过8位
 * 2.包括大小写字母.数字.其它符号,以上四种至少三种
 * 3.不能有相同长度超2的子串重复
 * 说明:长度超过2的子串
 */
public class PasswordVerification {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int[] type = new int[4];
            if (str.length() < 9) {
                System.out.println("NG");
            } else {
                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    if (ch >= '0' && ch <= '9') {
                        type[0] = 1;
                    } else if (ch >= 'a' && ch <= 'z') {
                        type[1] = 1;
                    } else if (ch >= 'A' && ch <= 'Z') {
                        type[2] = 1;
                    } else {
                        type[3] = 1;
                    }
                }
                if (type[0] + type[1] + type[2] + type[3] < 3) {
                    System.out.println("NG");
                } else {
                    System.out.println(passwordVerification(str));
                }
            }

        }
    }

    public static String passwordVerification(String str) {
        for (int i = 0; i < str.length() - 3; i++) {
            String str1 = str.substring(i, i + 3);
            String str2 = str.substring(i + 3, str.length());
            if (str2.contains(str1)) {
                return "NG";
            }
        }
        return "OK";
    }
}
