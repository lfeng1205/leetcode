package com.swordOffer.deleteNodeInList10;

/**
 * Created by Feng on 2017/5/7.
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时间删除该节点。
 */
public class DeleteNodeInList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        deleteNodeInList(node1, node2);

        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
    }

    public static void deleteNodeInList(ListNode pHead, ListNode deleteNode) {

        //判断节点是否为空
        if (pHead == null || deleteNode == null) {
            return;
        }

        //链表有多个节点，要删除的不是尾节点:O(1)时间
        if (deleteNode.next != null) {
            ListNode pNext = deleteNode.next;
            deleteNode.val = pNext.val;
            deleteNode.next = pNext.next;
        } else if (pHead == deleteNode) {
            //链表只有一个结点，删除头结点（也是尾结点）:O(1)时间
            deleteNode = null;
            pHead = null;
        } else {
            //链表有多个节点，要删除的是尾节点:O(n)时间
            ListNode pNode = pHead;
            while (pNode.next != deleteNode) {
                pNode = pNode.next;
            }

            pNode.next = null;
            deleteNode = null;
        }

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
