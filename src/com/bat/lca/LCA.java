package com.bat.lca;

import java.util.Scanner;

/**
 * Created by Feng on 2017/3/21.
 * 找出二叉树上任意两个节点的最近共同父节点
 */
public class LCA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();//数组的大小
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                num[i] = sc.nextInt();
            }

            int a = sc.nextInt();
            int b = sc.nextInt();

            TreeNode root = null;

            createTree(root, num, 0, num.length - 1);

            getLCA(root, a, b);
        }
    }

    //创建一个二叉树
    public static void createTree(TreeNode root, int[] num, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            root.v = num[mid];
            root.left = null;
            root.right = null;
            createTree(root.left, num, start, mid - 1);
            createTree(root.right, num, mid + 1, end);
        }
    }

    //查找最近的祖先节点
    public static int getLCA(TreeNode root, int a, int b) {

        return 0;
    }
}

class TreeNode {
    TreeNode left = null;
    TreeNode right = null;
    int v;

    TreeNode(int v) {
        this.v = v;
    }
}
