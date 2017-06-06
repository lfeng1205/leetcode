package com.swordOffer.treeDepth30;

/**
 * Created by Feng on 2017/6/6.
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 * 最长路径的长度为树的深度。
 */
public class TreeDepth {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);

        int length = treeDepth(node1);
        System.out.println(length);
    }

    private static int treeDepth(TreeNode pRoot) {

        if (pRoot == null) {
            return 0;
        }

        //递归遍历左右子树
        int nLeft = treeDepth(pRoot.left);
        int nRight = treeDepth(pRoot.right);

        return (nLeft > nRight) ? (nLeft + 1) : (nRight + 1);
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
