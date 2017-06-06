package com.swordOffer.isBalanced31;

/**
 * Created by Feng on 2017/6/6.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);

        boolean result = isBalanced(node1);
        System.out.println(result);
    }

    private static boolean isBalanced(TreeNode pRoot) {

        if (pRoot == null) {
            return true;
        }

        int nLeft = getLength(pRoot.left);
        int nRight = getLength(pRoot.right);

        //平衡条件
        if ((nLeft - nRight) > 1 || (nLeft - nRight) < -1) {
            return false;
        }

        return isBalanced(pRoot.left) && isBalanced(pRoot.right);
    }

    private static int getLength(TreeNode pRoot) {
        if (pRoot == null) {
            return 0;
        }

        //递归遍历左右子树
        int nLeft = getLength(pRoot.left);
        int nRight = getLength(pRoot.right);

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