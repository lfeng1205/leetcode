package com.swordOffer.lastNumberInCircle38;

import java.util.Scanner;

/**
 * Created by Feng on 2017/6/17.
 */
public class LastNumberOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//总人数
            int m = sc.nextInt();//删除第m个人
            int result = lastNumberOfCircle(n, m);
            System.out.println(result);
        }
    }

    private static int lastNumberOfCircle(int n, int m) {

        if (n < 1 || m < 1) {
            return -1;
        }

        //last为原序列最后一个数字的下标
        int last = 0;
        for (int i = 2; i <= n; i++) {
            //每次变化都是移除一个m，比如第一次移除2，然后剩下的3,4,0,1这四个数
            //就对应着0,1,2,3，再移除2，实际上就是移除原序列的0,，以此类推
            last = (last + m) % i;
        }
        return last;
    }
}

