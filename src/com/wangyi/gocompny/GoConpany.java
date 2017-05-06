package com.wangyi.gocompny;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/25.
 */
public class GoConpany {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

            int taxiSumTime = 0;
            int resultTime = Integer.MAX_VALUE;
            int n = Integer.parseInt(sc.nextLine());
            //打车点的个数

            int[] carX = new int[n];//车的横坐标
            int[] carY = new int[n];//车的纵坐标
            String carXStr = sc.nextLine();
            for (int i = 0; i < n; i++) {
                carX[i] = Integer.parseInt(carXStr.split(" ")[i]);
            }

            String carYStr = sc.nextLine();
            for (int i = 0; i < n; i++) {
                carY[i] = Integer.parseInt(carYStr.split(" ")[i]);
            }

            String conXY = sc.nextLine();
            int conX = Integer.parseInt(conXY.split(" ")[0]);
            int conY = Integer.parseInt(conXY.split(" ")[1]);

            String times = sc.nextLine();
            int walkTime = Integer.parseInt(times.split(" ")[0]);
            int taxTime = Integer.parseInt(times.split(" ")[1]);

            //步行去公司的总时间
            int walkSumTime = (Math.abs(conY) +
                    Math.abs(conX)) * walkTime;

            //打车去公司的总时间
            for (int i = 0; i < n; i++) {
                taxiSumTime = (Math.abs(carX[i]) + Math.abs(carY[i])) * walkTime +
                        (Math.abs(conX - carX[i]) +
                                Math.abs(conY - carY[i])) * taxTime;

                //通过判断，求出打车去公司的最短时间
                if (taxiSumTime < resultTime) {
                    resultTime = taxiSumTime;
                }
            }

            System.out.println(Math.min(resultTime, walkSumTime));
        }
    }

}
