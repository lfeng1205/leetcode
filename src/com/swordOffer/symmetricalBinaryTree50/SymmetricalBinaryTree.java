package com.swordOffer.symmetricalBinaryTree50;

/**
 * Created by Feng on 2017/6/27.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricalBinaryTree {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        boolean result = isSymmetrical(node1);
        System.out.println(result);

    }

    private static boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }

        return isSymmetrical(pRoot.left, pRoot.right);
    }

    private static boolean isSymmetrical(TreeNode pLeft, TreeNode pRight) {

        if (pLeft == null && pRight == null) {
            return true;
        }

        if (pLeft == null || pRight == null) {
            return false;
        }

        if (pLeft.val == pRight.val) {
            return isSymmetrical(pLeft.left, pRight.right)
                    && isSymmetrical(pLeft.right, pRight.left);
        }
        return false;
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