package com.huawei.choir;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/27.
 * 计算最少出列多少位同学，使得剩下的同学排成合唱队形
 * 说明：
 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
 */
public class Choir {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int temp = 0;
            int[] inc = new int[n];
            int[] dec = new int[n];
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            inc[0] = 1;
            for (int i = 1; i < n; i++) {
                inc[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[j] < arr[i] && inc[j] + 1 > inc[i]) {
                        inc[i] = inc[j] + 1;
                    }
                }
            }

            dec[n - 1] = 1;
            for (int i = n - 2; i >= 0; i--) {
                dec[i] = 1;
                for (int j = n - 1; j > i; j--) {

                    if (arr[j] < arr[i] && dec[j] + 1 > dec[i]) {
                        dec[i] = dec[j] + 1;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (inc[i] + dec[i] - 1 > temp)
                    temp = inc[i] + dec[i] - 1;
            }

            System.out.println(n - temp);
        }
    }
}
