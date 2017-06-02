package com.swordOffer.sortArrayForMinNumber24;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Feng on 2017/6/2.
 */
public class SortArrayForMinNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                numbers[i] = sc.nextInt();
            }

            String result = printMinNumber(numbers);
            System.out.println(result);
        }
    }

    public static String printMinNumber(int[] numbers) {

        String str = "";
        if (numbers.length <= 0) {
            return str;
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            list.add(numbers[i]);
        }

        //将数组转化为字符串，比较两个数的大小
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                String str1 = num1 + "" + num2;
                String str2 = num2 + "" + num1;
                return str1.compareTo(str2);
            }
        });

        for (Integer num : list) {
            str += num;
        }

        return str;
    }
}
