package com.swordOffer.nextNodeInBinaryTrees49;

/**
 * Created by Feng on 2017/6/27.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class NextNodeInBinaryTrees {
    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.next = node1;
        node3.next = node1;

        node2.left = node4;
        node2.right = node5;
        node4.next = node2;
        node5.next = node2;

        node3.left = node6;
        node3.right = node7;
        node6.next = node3;
        node7.next = node3;

        TreeLinkNode result = getNext(node4);
        System.out.println(result.val);
    }

    private static TreeLinkNode getNext(TreeLinkNode pNode) {

        if (pNode == null) {
            return null;
        }

        TreeLinkNode pTemp = null;
        //如果右子树不为null，那么它的下一个节点就是它的右子树的最左子节点
        if (pNode.right != null) {
            pTemp = pNode.right;
            while (pTemp.left != null) {
                pTemp = pTemp.left;
            }
            return pTemp;
        }
        //右子树为null情况,且还是父节点的右子节点
        //就沿着指向父节点的指针一直往上，直到找到一个是它父节点的左子节点的节点
        //如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点
        pTemp = pNode;
        while (pTemp.next != null && pTemp != pTemp.next.left) {
            pTemp = pTemp.next;
        }
        //右子树为null情况，如果节点是它父节点的左子节点，
        // 那么下一个节点就是它的父节点
        return pTemp.next;
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}