package com.huawei.ipCount;

import java.util.Scanner;

/**
 * Created by Feng on 2017/2/24.
 */
public class IpCount {
    public static int[] num = new int[7];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strIp = new String[1];

        while (sc.hasNext()) {
            strIp[0] = sc.nextLine();
            count(strIp);
        }

        for (int i = 0; i < 7; i++) {
            if (i == 6) {
                System.out.println(num[i]);
            } else {
                System.out.print(num[i] + " ");
            }
        }

        sc.close();
    }

    public static void count(String[] strIp) {
        String[] str = new String[2];// ~前后的字符串
        int[] ipInt = new int[4];
        int[] maskIpInt = new int[4];
        long mask = 0;
        for (int i = 0; i < strIp.length; i++) {
            str = strIp[i].split("~");
            String[] ip = str[0].split("\\.");
            String[] maskIp = str[1].split("\\.");

            if (ip.length < 4 || maskIp.length < 4) {
                num[5]++;
                continue;
            }

            for (int j = 0; j < 4; j++) {

                if ("".equals(ip[j]) || "".equals(maskIp[j])
                        || " ".equals(ip[j]) || " ".equals(maskIp[j])) {
                    num[5]++;
                    break;
                }
            }

            for (int k = 0; k < 4; k++) {

                ipInt[k] = Integer.parseInt(ip[k]);
                maskIpInt[k] = Integer.parseInt(maskIp[k]);
                if (ipInt[k] < 0 || ipInt[k] > 255 || maskIpInt[k] < 0
                        || maskIpInt[k] > 255) {
                    num[5]++;
                    break;
                }
            }

            if (maskIpInt[0] == 255 && maskIpInt[1] == 255
                    && maskIpInt[2] == 255 && maskIpInt[3] == 255) {
                num[5]++;
                continue;
            }

            mask = maskIpInt[0] * (0xffffff + 1l) + maskIpInt[1]
                    * (0xffff + 1l) + maskIpInt[2] * (0xff + 1l) + maskIpInt[3];

            if (((mask - 1l) | mask) != 0xffffffffl) {
                num[5]++;// 判断子网掩码合法性
                continue;
            }

            if ((ipInt[0] == 10)
                    || (ipInt[0] == 172 && ipInt[1] >= 16 && ipInt[1] <= 31)
                    || (ipInt[0] == 192 && ipInt[1] == 168)) {
                num[6]++;
                // continue;
            }
            if (ipInt[0] >= 1 && ipInt[0] <= 126) {
                num[0]++;
            }

            if (ipInt[0] >= 128 && ipInt[0] <= 191) {
                num[1]++;
            }
            if (ipInt[0] >= 192 && ipInt[0] <= 223) {
                num[2]++;
            }
            if (ipInt[0] >= 224 && ipInt[0] <= 239) {
                num[3]++;
            }
            if (ipInt[0] >= 240 && ipInt[0] <= 255) {
                num[4]++;
            }
        }
    }
}
