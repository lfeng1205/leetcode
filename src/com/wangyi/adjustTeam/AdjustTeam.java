package com.wangyi.adjustTeam;

import java.util.Scanner;

/**
 * Created by Feng on 2017/4/6.
 * 在幼儿园有n个小朋友排列为一个队伍，从左到右一个挨着一个编号为(0~n-1)。
 * 其中有一些是男生，有一些是女生，男生用'B'表示，女生用'G'表示。
 * 小朋友们都很顽皮，当一个男生挨着的是女生的时候就会发生矛盾。
 * 作为幼儿园的老师，你需要让男生挨着女生或者女生挨着男生的情况最少。
 * 你只能在原队形上进行调整，每次调整只能让相邻的两个小朋友交换位置，
 * 现在需要尽快完成队伍调整，你需要计算出最少需要调整多少次可以让上述情况最少。例如：
 * <p>
 * GGBBG -> GGBGB -> GGGBB
 * <p>
 * 这样就使之前的两处男女相邻变为一处相邻，需要调整队形2次
 */
public class AdjustTeam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputStr = sc.nextLine();
        int B = 0;//男孩的个数
        int G = 0;//女孩的个数
        int sumB = 0;//男孩所对应的索引和
        int sumG = 0;//女孩所对应的索引和

        /**
         *
         *如果有B个男孩，则移到最左边的index分别为：0,1,2...B-1,所以所有index的和为（B-1）*B/2
         *一次遍历，计算目前男孩所在的index的和为sumB，则sumB减去上面的和就是所求的结果。
         *因此只要一次遍历，计算男孩所在的男孩的个数和男孩所在的index的和，求之差就行了。女孩同理。最后求最小值。
         */

        for (int i = 0; i < inputStr.length(); i++) {
            if (inputStr.charAt(i) == 'G') {
                G++;//计算字符串中女孩的个数
                sumG += i;
            } else {
                B++;//计算字符串中男孩的个数
                sumB += i;
            }
        }

        int resB = sumB - B * (B - 1) / 2;//移动男孩所需要的次数
        int resG = sumG - G * (G - 1) / 2;//移动女孩所需要的次数

        int res = resB < resG ? resB : resG;//求最小值

        System.out.println(res);
    }
}
