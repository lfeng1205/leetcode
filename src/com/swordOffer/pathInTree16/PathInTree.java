package com.swordOffer.pathInTree16;

import java.util.ArrayList;

/**
 * Created by Feng on 2017/5/14.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree {

    //存储节点的值
    static ArrayList<Integer> list = new ArrayList<Integer>();
    //存储路径
    static ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        ArrayList<ArrayList<Integer>> result = findPath(node1, 22);

        for (ArrayList<Integer> list : result) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
        }
    }

    public static ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {

        if (root == null) {
            return listAll;
        }

        //添加根节点
        list.add(root.val);
        //当前目标的值为减去根节点后的值
        target -= root.val;

        //如果节点为叶子节点且路径的值和目标的值相等
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<>(list));
        }

        //采用递归
        findPath(root.left, target);
        findPath(root.right, target);

        //节点回溯
        list.remove(list.size() - 1);

        return listAll;

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
