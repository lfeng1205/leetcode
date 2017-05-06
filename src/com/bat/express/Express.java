package com.bat.express;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Feng on 2017/4/26.
 * 2 3  4 * ^ 5 +
 */
public class Express {
    public static void main(String[] args) {

        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if (line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {

        Stack<Integer> stack = new Stack<>();
        String[] strs = expr.split(" ");
        for (int i = 0; i < strs.length; i++) {
            char ch = strs[i].charAt(0);
            int num = ch - '0';
            if (num >= 0 && num <= 9) {
                if (stack.size() > 16) {
                    return -2;
                }
                stack.add(num);
            } else {
                if (ch == '*') {
                    if (stack.size() < 2) {
                        return -1;
                    }
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    if (stack.size() > 16) {
                        return -2;
                    }
                    stack.add(num1 * num2);
                }

                if (ch == '^') {
                    if (stack.size() < 1) {
                        return -1;
                    }
                    int num3 = stack.pop();
                    if (stack.size() > 16) {
                        return -2;
                    }
                    stack.add(num3 + 1);
                }

                if (ch == '+') {
                    if (stack.size() < 2) {
                        return -1;
                    }
                    int num4 = stack.pop();
                    int num5 = stack.pop();
                    if (stack.size() > 16) {
                        return -2;
                    }
                    stack.add(num4 + num5);
                }
            }
        }

        return stack.peek();
    }
}
