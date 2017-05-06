package com.swordOffer.queueWithTwoStacks05;

import java.util.Stack;

/**
 * Created by Feng on 2017/5/2.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class QueueWithTwoStacks {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);

        while (!solution.stack1.isEmpty()) {
            System.out.println(solution.pop());
        }
    }
}

class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    //进栈
    public void push(int node) {
        stack1.push(node);
    }

    //出栈
    public int pop() {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return result;
    }
}
