package com.swordOffer.getLastCommonParent57;

/**
 * Created by Feng on 2017/7/2.
 * 求一棵树中的任意两个节点最近的祖先节点
 */
public class GetLastCommonParent {

    /**
     * 树为二叉搜索树
     *
     * @param pRoot
     * @param pNode1
     * @param pNode2
     * @return
     */
    private static TreeNode getLastCommonParentInBinarySearchTree(TreeNode pRoot, TreeNode pNode1, TreeNode pNode2) {
        int pLeft = pNode1.val;
        int pRight = pNode2.val;

        //二叉查找树内，如果左结点大于右结点，不对，交换
        if (pLeft > pRight) {
            int temp = pLeft;
            pLeft = pRight;
            pRight = temp;
        }

        while (true) {
            //如果pRoot的值大于pNode1和pNode2的值就在右子树找
            if (pRoot.val > pRight) {
                pRoot = pRoot.right;
            } else if (pRoot.val < pLeft) {
                pRoot = pRoot.left;
            } else {
                return pRoot;
            }
        }
    }

    /**
     * 普通二叉树
     * 如果每个结点都有一个指针指向它的父结点，于是我们可以从任何一个结点出发，
     * 得到一个到达树根结点的单向链表。
     * 因此这个问题转换为两个单向链表的第一个公共结点
     *
     * @param pRoot  根节点
     * @param pNode1 节点1
     * @param pNode2 节点2
     * @return
     */
    private static TreeNode getLastCommonParent(TreeNode pRoot, TreeNode pNode1, TreeNode pNode2) {
        if (pRoot == null) {
            return null;
        }

        if (pRoot == pNode1 || pRoot == pNode2) {
            return pRoot;
        }

        TreeNode pLeft;
        TreeNode pRight;

        pLeft = getLastCommonParent(pRoot.left, pNode1, pNode2);
        pRight = getLastCommonParent(pRoot.right, pNode1, pNode2);

        if (pLeft != null) {
            return pLeft;
        } else if (pRight != null) {
            return pRight;
        } else if (pLeft != null && pRight != null) {
            return pRoot;
        } else {
            return null;
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
