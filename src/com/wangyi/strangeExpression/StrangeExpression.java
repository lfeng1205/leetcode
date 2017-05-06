package com.wangyi.strangeExpression;

/**
 * 常规的表达式求值，我们都会根据计算的优先级来计算。比如*的优先级就高于+-。
 * 但是小易所生活的世界的表达式规则很简单，从左往右依次计算即可，而且小易所在的世界没有除法，
 * 意味着表达式中没有/，只有(+, - 和 *)。现在给出一个表达式，需要你帮忙计算出小易所在的世界这个表达式的值为多少
 * <p>
 * 输入描述:
 * <p>
 * 输入为一行字符串，即一个表达式。其中运算符只有-,+,*。参与计算的数字只有0~9.
 * <p>
 * 保证表达式都是合法的，排列规则如样例所示。
 * <p>
 * 输出描述:
 * <p>
 * 输出一个数，即表达式的值
 * <p>
 * 输入例子:
 * <p>
 * 3+5*7
 * <p>
 * 输出例子:
 * 56
 */

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Feng on 2017/4/7.
 */
public class StrangeExpression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String expression = sc.nextLine();//输入表达式
            int result = strangeExpression(expression);
            System.out.println(result);
        }
    }

    private static int strangeExpression(String expression) {
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        //将字符串转换成字符数组
        char[] chs = expression.toCharArray();
        //将第一个数字入栈
        stack.push(chs[0] - '0');
        for (int i = 1; i < chs.length - 1; i += 2) {
            //判断运算符，将运算结果入栈
            if (expression.charAt(i) == '+') {
                num = stack.pop() + (chs[i + 1] - '0');
                stack.push(num);
            }

            if (expression.charAt(i) == '-') {
                num = stack.pop() - (chs[i + 1] - '0');
                stack.push(num);
            }

            if (expression.charAt(i) == '*') {
                num = stack.pop() * (chs[i + 1] - '0');
                stack.push(num);
            }
        }
        return stack.pop();
    }
}
