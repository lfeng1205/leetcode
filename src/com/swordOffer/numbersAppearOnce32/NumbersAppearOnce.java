package com.swordOffer.numbersAppearOnce32;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Feng on 2017/6/7.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class NumbersAppearOnce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            int[] num1 = new int[1];
            int[] num2 = new int[1];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }

            findNumsAppearOnce(array, num1, num2);

            System.out.println(num1[0] + "---" + num2[0]);
        }
    }

    private static void findNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        if (array.length < 2) {
            return;
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            //如果集合不存在，就添加到集合
            if (!arrayList.contains(num)) {
                arrayList.add(num);
            } else {
                //删除出现两次的数字
                for (int j = 0; j < arrayList.size(); j++) {
                    if (num == arrayList.get(j)) {
                        arrayList.remove(arrayList.get(j));
                    }
                }
            }
        }

        num1[0] = arrayList.get(0);
        num2[0] = arrayList.get(1);
    }
}
