package com.swordOffer.sequenceOfBST15;

import java.util.Scanner;

/**
 * Created by Feng on 2017/5/14.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class SequenceOfBST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//数组的大小
            int[] postOrder = new int[n];
            for (int i = 0; i < n; i++) {
                postOrder[i] = sc.nextInt();
            }

            boolean result = verifySquenceOfBST(postOrder);
            if (result) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }

    public static boolean verifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 0) {
            return false;
        }

        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    private static boolean isTreeBST(int[] sequence, int start, int end) {

        //如果至多只有一个元素
        if (end <= start) {
            return true;
        }

        int i = start;

        //在二叉树搜索中左子树的节点小于根节点
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                break;
            }
        }

        //在二叉树搜索树中右子树的节点大于根节点
        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }

        return isTreeBST(sequence, start, i - 1) &&
                isTreeBST(sequence, i, end - 1);

    }
}
