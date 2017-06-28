package com.swordOffer.kthNodeInBST54;

import java.util.Stack;

/**
 * Created by Feng on 2017/6/28.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class KthNodeInBST {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        TreeNode result = KthNode(node1,3);
        System.out.println(result.val);
    }

    private static TreeNode KthNode(TreeNode pRoot, int k) {

        //记录第几个节点
        int count = 0;

        if (count > k || pRoot == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pResult = null;
        //使用中序遍历的方式
        while (pRoot != null || !stack.isEmpty()) {
            //找到最左子节点
            while (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            }

            TreeNode pNode = stack.pop();
            count++;

            if (count == k) {
                pResult = pNode;
            }

            //求当前节点的右子节点
            pRoot = pNode.right;
        }
        return pResult;
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