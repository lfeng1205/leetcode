package com.swordOffer.stackPushPopOrder14;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Feng on 2017/5/11.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如列1、2、3、4、5是某栈的压栈序列，序列5、4、3、2、1
 * 是该栈对应的一个弹出序列，但4、3、5、1、2就不可能是该压栈序列的弹出序列。
 */
public class StackPushPopOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组的大小
            int[] push = new int[n];//表示栈的压入顺序
            for (int i = 0; i < n; i++) {
                push[i] = sc.nextInt();
            }

            int[] pop = new int[n];//弹出顺序
            for (int i = 0; i < n; i++) {
                pop[i] = sc.nextInt();
            }

            boolean result = isPopOrder(push, pop);
            System.out.println(result);
        }
    }

    /**
     * 判断第二个序列是否为该栈的探春序列
     *
     * @param push
     * @param pop
     * @return
     */
    private static boolean isPopOrder(int[] push, int[] pop) {

        boolean flag = false;

        Stack<Integer> stack = new Stack<>();

        // 输入校验，参数不能为空，并且两个数组中必须有数字，并且两个数组中的数字个数相同
        // 否则返回false
        if (push == null || pop == null || pop.length == 0 || push.length == 0
                || push.length != pop.length) {
            return false;
        }

        // 用于记录入栈数组元素的处理位置
        int pushIndex = 0;
        // 用于记录出栈数组元素的处理位置
        int popIndex = 0;

        // 如果还有出栈元素要处理
        while (popIndex < pop.length) {
            // 入栈元素还未全部入栈的条件下，如果栈为空，
            // 或者栈顶的元素不与当前处理的相等，
            // 则一直进行栈操作，
            // 直到入栈元素全部入栈或者找到了一个与当出栈元素相等的元素
            while (pushIndex < push.length && (stack.isEmpty() ||
                    stack.peek() != pop[popIndex])) {
                // 入栈数组中的元素入栈
                stack.push(push[pushIndex]);
                // 指向下一个要处理的入栈元素
                pushIndex++;
            }

                //如果在上一步的入栈过程中找到了与出栈的元素相等的元素
            if (stack.peek() == pop[popIndex]) {
                // 将元素出栈
                stack.pop();
                // 处理下一个出栈元素
                popIndex++;
            }
            // 如果没有找到与出栈元素相等的元素，说明这个出栈顺序是不合法的
            // 就返回false
            else {
                return false;
            }
        }

        return true;
    }
}
