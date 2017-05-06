package com.leetcode.preorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Feng on 2016/12/14.
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * return[1,2,3].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        ArrayList<Integer> result = preorderTraversal(node1);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);

            if (treeNode.right != null) {
                stack.add(treeNode.right);
            }

            if (treeNode.left != null) {
                stack.add(treeNode.left);
            }

        }

        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
