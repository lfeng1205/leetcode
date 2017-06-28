package com.swordOffer.printTreesInZigzag51;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Feng on 2017/6/28.
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreesInZigzag {
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

        printTreesInZigzag2(node1);
//        ArrayList<ArrayList<Integer>> result = printTreesInZigzag(node1);
//        for (ArrayList<Integer> list : result) {
//            System.out.println(list);
//        }
    }

    private static ArrayList<ArrayList<Integer>> printTreesInZigzag(TreeNode pRoot) {

        if (pRoot == null) {
            return null;
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();

        queue.addLast(null);
        queue.addLast(pRoot);

        //从左到右打印的标识符
        boolean leftToRight = true;

        while (queue.size() != 1) {
            TreeNode pNode = queue.removeFirst();
            if (pNode == null) {//到达分层节点
                Iterator<TreeNode> iterator = null;
                if (leftToRight) {//从前往后遍历
                    iterator = queue.iterator();
                } else {
                    iterator = queue.descendingIterator();//从后往前遍历
                }
                leftToRight = !leftToRight;
                while (iterator.hasNext()) {
                    TreeNode pTemp = (TreeNode) iterator.next();
                    arrayList.add(pTemp.val);
                }

                arrayLists.add(new ArrayList<>(arrayList));
                //在这清空arrayList
                arrayList.clear();
                //添加分层符
                queue.addLast(null);
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

    private static void printTreesInZigzag2(TreeNode pRoot) {

        if (pRoot == null) {
            return ;
        }

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();

        //存奇数层点，从左到右
        Stack<TreeNode> leftToRight = new Stack<>();
        //存偶数层点，从右到左
        Stack<TreeNode> rightToleft = new Stack<>();

        int layer = 1;//层数

        if (pRoot != null) {
            leftToRight.push(pRoot);
        }

        while (!leftToRight.isEmpty() || !rightToleft.isEmpty()) {
            //奇数层的情况
            if (layer % 2 != 0) {
                ArrayList<Integer> list = new ArrayList<>();
                while (!leftToRight.isEmpty()) {
                    TreeNode pNode = leftToRight.pop();
                    if (pNode != null) {
                        list.add(pNode.val);
                        System.out.print(pNode.val + " ");
                        rightToleft.push(pNode.left);
                        rightToleft.push(pNode.right);
                    }
                }
                if (!list.isEmpty()) {
                    arrayLists.add(list);
                    layer++;
                    System.out.println();
                }
                //偶数层的情况
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                while (!rightToleft.isEmpty()) {
                    TreeNode pNode = rightToleft.pop();
                    if (pNode != null) {
                        list.add(pNode.val);
                        System.out.print(pNode.val + " ");
                        leftToRight.push(pNode.right);
                        leftToRight.push(pNode.left);
                    }
                }
                if (!list.isEmpty()) {
                    arrayLists.add(list);
                    layer++;
                    System.out.println();
                }
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