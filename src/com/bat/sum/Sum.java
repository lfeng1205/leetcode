package com.bat.sum;

/**
 * Created by Feng on 2017/4/28.
 */
public class Sum {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            switch (i) {
                default:
                    sum += 4;

                case 1:
                    sum += 1;

                case 2:
                    sum += 2;

                case 3:
                    sum += 3;
            }
        }

        //结果是24
        System.out.println(sum);
    }
}
