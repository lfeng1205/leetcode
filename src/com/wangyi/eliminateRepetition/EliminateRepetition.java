package com.wangyi.eliminateRepetition;

import java.util.*;

/**
 * Created by Feng on 2017/4/6.
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，
 * 但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他
 * <p>
 * 输入包括两行：
 * 第一行为序列长度n(1 ≤ n ≤ 50)
 * 第二行为n个数sequencei，以空格分隔
 * <p>
 * 输出消除重复元素之后的序列，以空格分隔，行末无空格
 * <p>
 * 输入例子:
 * 9
 * 100 100 100 99 99 99 100 100 100
 * <p>
 * 输出例子:
 * 99 100
 */
public class EliminateRepetition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//序列长度n

            int[] sequence = new int[n];
            for (int i = 0; i < sequence.length; i++) {
                sequence[i] = sc.nextInt();
            }

            List<Integer> list = eliminateRepetition(sequence, n);

            for (int i = 0; i < list.size() - 1; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println(list.get(list.size() - 1));
        }
    }

    public static List<Integer> eliminateRepetition(int[] arr, int n) {
        List<Integer> resList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (!stack.contains(arr[i])) {//去除重复的数字
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()) {//利用栈的先进后出,将数字重排
            resList.add(stack.pop());
        }

        return resList;
    }
}

