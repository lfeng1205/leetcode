package com.huawei.picSort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Feng on 2017/3/8.
 */
public class PicSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            System.out.println(cs);
        }
        sc.close();
    }
}
