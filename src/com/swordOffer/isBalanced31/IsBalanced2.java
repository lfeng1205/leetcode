package com.swordOffer.isBalanced31;

/**
 * Created by Feng on 2017/6/6.
 */
public class IsBalanced2 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);
        node1.left.left = new TreeNode(4);
        node1.left.left.left = new TreeNode(5);

        boolean result = isBalanced(node1);
        System.out.println(result);
    }

    private static boolean isBalanced(TreeNode pRoot) {
        Depth depth = new Depth();
        return isBalanced(pRoot, depth);
    }

    //增加一个计算树深度的指针
    private static boolean isBalanced(TreeNode pRoot, Depth pDepth) {
        if (pRoot == null) {
            pDepth.depth = 0;
            return true;
        }

        Depth nLeft = new Depth();
        Depth nRight = new Depth();

        //一边遍历一边判断每个节点是不是平衡
        if (isBalanced(pRoot.left, nLeft)
                && isBalanced(pRoot.right, nRight)) {
            if (nLeft.depth - nRight.depth <= 1 &&
                    nLeft.depth - nRight.depth >= -1) {
                pDepth.depth = 1 + (nLeft.depth > nRight.depth
                        ? nLeft.depth : nRight.depth);
                return true;
            }
        }
        return false;
    }
}

class Depth {
    int depth;
}
