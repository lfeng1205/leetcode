package com.huawei.work;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/24.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int workCity = sc.nextInt();//出差城市
            int fogCity = sc.nextInt();//大雾城市
        }
    }

    public static int getTime(int workCity, int fogCity) {
        int time = 0;
        int[][] citys = new int[7][7];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (fogCity == 0) {
                    if ((char) citys[5][j] != 'M') {
                        time = Math.min(citys[5][j] + citys[j][workCity], time);
                    } else {
                        time = 1000;
                    }

                } else if (fogCity != 0) {
                }
            }
        }
        return 0;
    }
}
