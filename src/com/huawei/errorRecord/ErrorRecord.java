package com.huawei.errorRecord;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Feng on 2017/2/24.
 * <p>
 * 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。
 * <p>
 * 处理：
 * <p>
 * 1、 记录最多8条错误记录，循环记录，对相同的错误记录（净文件名称和行号完全匹配）只记录一条，错误计数增加；
 * <p>
 * 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 * <p>
 * 3、 输入的文件可能带路径，记录文件名称不能带路径。
 * <p>
 * <p>
 * 输入描述:
 * 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。
 * <p>
 * <p>
 * 输出描述:
 * 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：
 * <p>
 * 输入例子:
 * E:\V1R2\product\fpgadrive.c   1325
 * <p>
 * 输出例子:
 * fpgadrive.c 1325 1
 */
public class ErrorRecord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        int num = 0;
        while (sc.hasNext()) {
            String str = sc.next();
            int lineNum = sc.nextInt();
            String[] strs = str.split("\\\\");
            String s = strs[strs.length - 1];
            if (s.length() > 16) {//如果超过16个字符的文件名称，只记录文件的最后有效16个字符；
                s = s.substring(s.length() - 16);
            }

            String key = s + " " + lineNum;
            int value = 1;
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
                num++;
            } else {
                map.put(key, value);
                num++;
            }
            if (num == 5) {
                break;
            }

        }

        sc.close();

        int count = 0;
        for (String s : map.keySet()) {
            count++;
            if (count > (map.keySet().size() - 8)) {
                System.out.println(s + " " + map.get(s));
            }
        }
    }
}
