package com.leetcode.evaluateReversePolishNotation;

import java.util.Stack;

/**
 * Created by Feng on 2016/11/30.
 */
public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] s = {"4", "13", "5", "/", "+"};
        int result = evalRPN(s);
        System.out.println("result is " + result);
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            try {
                int num = Integer.parseInt(tokens[i]);
                stack.add(num);
            } catch (Exception e) {
                //后进先出
                int b = stack.pop();
                int a = stack.pop();
                stack.add(get(a, b, tokens[i]));
            }
        }
        return stack.pop();
    }

    public static int get(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;

            case "-":
                return a - b;

            case "*":
                return a * b;

            case "/":
                return a / b;

            default:
                return 0;
        }
    }

}
