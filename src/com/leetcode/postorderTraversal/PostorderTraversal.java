package com.leetcode.postorderTraversal;

import java.util.ArrayList;

/**
 * Created by Feng on 2016/12/14.
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * For example:
 * Given binary tree{1,#,2,3},
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * return[3,2,1].
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class PostorderTraversal {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        node1.right = new TreeNode(2);
        node1.right.left = new TreeNode(3);

        ArrayList<Integer> list = postorderTraversal(node1);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    public static void postOrder(TreeNode root, ArrayList<Integer> result) {

        if (root == null) {
            return;
        }

        if (root.left != null) {
            postOrder(root.left, result);
        }
        if (root.right != null) {
            postOrder(root.right, result);
        }

        result.add(root.val);
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