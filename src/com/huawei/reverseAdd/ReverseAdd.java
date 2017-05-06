package com.huawei.reverseAdd;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/24.
 */
public class ReverseAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String numStr = sc.next();
            int firstNum = Integer.parseInt(numStr.split(",")[0]);
            int secondNum = Integer.parseInt(numStr.split(",")[1]);

            int result = reverseAdd(firstNum, secondNum);
            System.out.println(result);
        }
    }

    public static int reverse(int num) {
        int temp = 0;
        while (num != 0) {
            temp = temp * 10 + num % 10;
            num = num / 10;
        }

        return temp;
    }

    public static int reverseAdd(int a, int b) {
        return reverse(a) + reverse(b);
    }
}
