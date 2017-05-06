package com.huawei.simplePassword;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/25.
 * <p>
 * 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。
 * 哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
 * <p>
 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，
 * 他通过一种算法把这个密码变换成YUANzhi1987，这个密码是他的名字和出生年份，怎么忘都忘不了，
 * 而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
 * <p>
 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6,
 * pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，
 * 数字和其他的符号都不做变换，
 * <p>
 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，
 * 如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
 * 输入例子：
 * YUANzhi1987
 * <p>
 * 输出例子：
 * zvbo9441987
 */
public class SimplePassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String s = "";
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    s = s + ch;
                }

                if (ch >= 'a' && ch <= 'z') {
                    if (ch >= 'a' && ch <= 'c') {
                        s = s + 2;
                    }
                    if (ch >= 'd' && ch <= 'f') {
                        s = s + 3;
                    }

                    if (ch >= 'g' && ch <= 'i') {
                        s = s + 4;
                    }

                    if (ch >= 'j' && ch <= 'l') {
                        s = s + 5;
                    }

                    if (ch >= 'm' && ch <= 'o') {
                        s = s + 6;
                    }

                    if (ch >= 'p' && ch <= 's') {
                        s = s + 7;
                    }

                    if (ch >= 't' && ch <= 'v') {
                        s = s + 8;
                    }
                    if (ch >= 'w' && ch <= 'z') {
                        s = s + 9;
                    }
                }

                if (ch >= 'A' && ch <= 'Z') {
                    char c = Character.toLowerCase(ch);
                    if (c == 'z') {
                        s = s + "a";
                    } else {
                        s = s + (char) (Integer.valueOf(c) + 1);
                    }
                }
            }

            System.out.println(s);
        }

        sc.close();
    }

}
