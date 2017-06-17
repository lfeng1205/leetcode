package com.swordOffer.mirrorOfBinaryTree39;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Feng on 2017/6/17.
 */
public class MirrorOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(10);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(9);
        TreeNode node6 = new TreeNode(11);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;

        mirroOfBinaryTree(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode pNode = queue.poll();
            System.out.print(pNode.val + " ");

            if (pNode.left != null) {
                queue.add(pNode.left);
            }

            if (pNode.right != null) {
                queue.add(pNode.right);
            }
        }
    }

    private static void mirroOfBinaryTree(TreeNode root) {

        if (root == null) {
            return;
        }

        //利用栈先进后出的特点
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode pNode = stack.pop();
            //如果左子树不为空或者右子树不为空
            if (pNode.left != null || pNode.right != null) {
                TreeNode pLeft = pNode.left;
                TreeNode pRight = pNode.right;

                //交换左右子树
                pNode.left = pRight;
                pNode.right = pLeft;
            }

            //如果左子树不为空，入栈
            if (pNode.left != null) {
                stack.push(pNode.left);
            }

            //如果右子树不为空，入栈
            if (pNode.right != null) {
                stack.push(pNode.right);
            }
        }
    }


}

class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
