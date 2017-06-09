package com.swordOffer.continueSquenceWithSum33;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Feng on 2017/6/9.
 * 找出所有和为S的连续正数序列
 * 输出所有和为S的连续正数序列。
 * 序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class ContinueSquenceWithSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int sum = sc.nextInt();
            ArrayList<ArrayList<Integer>> arrayLists = findContinuousSequence(sum);
            for (ArrayList list : arrayLists) {
                for (int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (sum < 2) {
            return arrayLists;
        }

        int start = 1;
        int end = 2;

        //开始的数字不能超过sum的一半
        while (start != (sum + 1) / 2) {
            int currentSum = sumOfList(start, end);
            ArrayList<Integer> list = new ArrayList<>();
            if (currentSum == sum) {
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                arrayLists.add(list);
                start++;
                end++;
                //如果序列和小于sum，end要++
            } else if (currentSum < sum) {
                end++;
                //如果序列和大于sum，start要++
            } else {
                start++;
            }
        }

        return arrayLists;
    }

    /**
     * 集合中连续正数序列的和
     *
     * @param start
     * @param end
     * @return
     */
    private static int sumOfList(int start, int end) {

        int sum = start;

        for (int i = start + 1; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
