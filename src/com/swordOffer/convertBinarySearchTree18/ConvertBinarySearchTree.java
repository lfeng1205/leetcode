package com.swordOffer.convertBinarySearchTree18;

/**
 * Created by Feng on 2017/5/15.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class ConvertBinarySearchTree {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode result = convertNode(node1);
        System.out.println(result.val);

    }

    public static TreeNode convertNode(TreeNode pRootOfTree) {

        //如果根节点为空,返回空
        if (pRootOfTree == null) {
            return null;
        }

        //如果只有根节点
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            return pRootOfTree;
        }

        //转换左子树
        TreeNode pLeft = convertNode(pRootOfTree.left);
        TreeNode pNode = pLeft;
        while (pNode != null && pNode.right != null) {
            pNode = pNode.right;
        }
        if (pLeft != null) {
            pNode.right = pRootOfTree;
            pRootOfTree.left = pNode;
        }

        //转换右子树
        TreeNode pRight = convertNode(pRootOfTree.right);
        if (pRight != null) {
            pRootOfTree.right = pRight;
            pRight.left = pRootOfTree;
        }

        return pLeft != null ? pLeft : pRootOfTree;

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