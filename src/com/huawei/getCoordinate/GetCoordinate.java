package com.huawei.getCoordinate;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/22.
 * <p>
 * 开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。
 * 从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。
 * <p>
 * 输入：
 * <p>
 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
 * <p>
 * 坐标之间以;分隔。
 * <p>
 * 非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。
 * <p>
 * 下面是一个简单的例子 如：
 * <p>
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * <p>
 * 处理过程：
 * <p>
 * 起点（0,0）
 * <p>
 * +   A10   =  （-10,0）
 * <p>
 * +   S20   =  (-10,-20)
 * <p>
 * +   W10  =  (-10,-10)
 * <p>
 * +   D30  =  (20,-10)
 * <p>
 * +   x    =  无效
 * <p>
 * +   A1A   =  无效
 * <p>
 * +   B10A11   =  无效
 * <p>
 * +  一个空 不影响
 * <p>
 * +   A10  =  (10,-10)
 * <p>
 * 结果 （10， -10）
 * <p>
 * 输入描述:
 * 一行字符串
 * <p>
 * 输出描述:
 * 最终坐标，以,分隔
 * <p>
 * 输入例子:
 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
 * <p>
 * 输出例子:
 * 10,-10
 */
public class GetCoordinate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String inputStr = sc.nextLine();
            String result = getCoordinate(inputStr);
            System.out.println(result);
        }
    }

    public static String getCoordinate(String inputStr) {
        StringBuilder builder = new StringBuilder();
        String[] str = inputStr.split(";");
        int x = 0;
        int y = 0;
        for (int i = 0; i < str.length; i++) {
            try {
                int b = Integer.parseInt(str[i].substring(1, str[i].length()));
                if (str[i].charAt(0) == 'A') {
                    x = x - b;
                }

                if (str[i].charAt(0) == 'W') {
                    y = y + b;
                }

                if (str[i].charAt(0) == 'S') {
                    y = y - b;
                }

                if (str[i].charAt(0) == 'D') {
                    x = x + b;
                }
            } catch (Exception e) {
                continue;
            }
        }

        builder.append(x).append(',').append(y);
        return builder.toString();
    }
}
