package com.swordOffer.reConstructBinaryTree04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Feng on 2017/5/1.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();//二叉树的节点数

            int[] preorder = new int[n];//二叉树先序遍历
            for (int i = 0; i < n; i++) {
                preorder[i] = sc.nextInt();
            }

            int[] inorder = new int[n];//二叉树中序遍历
            for (int i = 0; i < n; i++) {
                inorder[i] = sc.nextInt();
            }

            TreeNode root = reConstruct(preorder, inorder);
            System.out.print(root.val + " ");

            //使用对列输出重构的二叉树
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            //利用对列先进先出的特点
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    System.out.print(node.left.val + " ");
                    queue.add(node.left);
                }
                if (node.right != null) {
                    System.out.print(node.right.val + " ");
                    queue.add(node.right);
                }
            }
        }
    }

    private static TreeNode reConstruct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        return reConstructCore(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode reConstructCore(int[] preorder, int startPre, int endPre,
                                            int[] inorder, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        //获取根节点，先序遍历的第一个值即根节点
        TreeNode root = new TreeNode(preorder[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == preorder[startPre]) {
                //构建左子树
                root.left = reConstructCore(preorder, startPre + 1, startPre + i - startIn,
                        inorder, startIn, i - 1);
                //构建右子树
                root.right = reConstructCore(preorder, i - startIn + startPre + 1, endPre,
                        inorder, i + 1, endIn);
            }
        }

        return root;
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