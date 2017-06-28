package com.swordOffer.printTreesInLines52;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Feng on 2017/6/28.
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTreesInLines {
    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        ArrayList<ArrayList<Integer>> arrayLists = printTreesInLines(node1);
        for (ArrayList<Integer> list : arrayLists) {
            System.out.println(list);
        }
    }

    private static ArrayList<ArrayList<Integer>> printTreesInLines(TreeNode pRoot) {

        if (pRoot == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        //添加层分隔符
        queue.addLast(null);
        queue.addLast(pRoot);

        while (queue.size() != 1) {
            TreeNode pNode = queue.removeFirst();
            if (pNode == null) {//到达分层节点
                Iterator<TreeNode> iterator;
                iterator = queue.iterator();//从前往后遍历
                while (iterator.hasNext()) {
                    TreeNode pTemp = iterator.next();
                    list.add(pTemp.val);
                }
                arrayLists.add(new ArrayList<>(list));
                list.clear();
                queue.addLast(null);//添加层分隔符
                continue;
            }

            if (pNode.left != null) {
                queue.addLast(pNode.left);
            }
            if (pNode.right != null) {
                queue.addLast(pNode.right);
            }
        }
        return arrayLists;
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