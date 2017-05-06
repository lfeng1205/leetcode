package com.wangyi.setNum;

/**
 * 小易最近在数学课上学习到了集合的概念,集合有三个特征：1.确定性 2.互异性 3.无序性.
 * <p>
 * 小易的老师给了小易这样一个集合：
 * <p>
 * S = { p/q | w ≤ p ≤ x, y ≤ q ≤ z }
 * <p>
 * 需要根据给定的w，x，y，z,求出集合中一共有多少个元素。小易才学习了集合还解决不了这个复杂的问题,需要你来帮助他。
 * <p>
 * 输入描述:
 * <p>
 * 输入包括一行：
 * <p>
 * 一共4个整数分别是w(1 ≤ w ≤ x)，x(1 ≤ x ≤ 100)，y(1 ≤ y ≤ z)，z(1 ≤ z ≤ 100).以空格分隔
 * <p>
 * 输出描述:
 * <p>
 * 输出集合中元素的个数
 * <p>
 * 输入例子:
 * <p>
 * 1 10 1 1
 * <p>
 * 输出例子:
 * <p>
 * 10
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by Feng on 2017/4/7.
 */
public class SetNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String numStr = sc.nextLine();
            int w = Integer.parseInt(numStr.split(" ")[0]);
            int x = Integer.parseInt(numStr.split(" ")[1]);
            int y = Integer.parseInt(numStr.split(" ")[2]);
            int z = Integer.parseInt(numStr.split(" ")[3]);

            int count = setNum(w, x, y, z);

            System.out.println(count);
        }
    }

    private static int setNum(int w, int x, int y, int z) {

        Set set = new HashSet<>();
        for (int q = y; q <= z; q++) {
            for (int p = w; p <= x; p++) {
                //判断p/q是否为整数
                set.add(p * 1.0 / q);
            }
        }
        return set.size();
    }
}
