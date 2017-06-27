package com.swordOffer.deleteDuplicatedListNode48;

/**
 * Created by Feng on 2017/6/27.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicatedListNode {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        ListNode result = deleteDuplication(node1);
        System.out.println(result.val);
    }

    private static ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null) {
            return null;
        }

        ListNode pNode = pHead;
        //设置一个头结点
        ListNode pFirst = new ListNode(-1);

        ListNode pPreNode = pFirst;
        pFirst.next = pHead;

        boolean flag = false;

        while (pNode != null) {
            ListNode pNext = pNode.next;
            //如果pNode的下个节点为空，则跳出循环
            if (pNext == null) {
                break;
            }
            if (pNext.val == pNode.val) {
                //判断值是不是重复
                while (pNext != null && pNext.val == pNode.val) {
                    pNext = pNext.next;
                }
                //为了使链表不断仍然相连，要使pPreNode和后面值比当前节点要大的节点相连
                //确保pPreNode要始终与下一个没有重复的节点连接在一起
                pPreNode.next = pNext;
                pNode = pNext;
            } else {
                if (!flag) {
                    pFirst.next = pNode;
                    flag = true;
                }
                pPreNode = pNode;
                pNode = pNext;
            }
        }
        return pFirst.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}