package com.swordOffer.reverseList12;

/**
 * Created by Feng on 2017/5/8.
 * 输入一个链表，反转链表后，输出链表的所有元素。
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);

        ListNode result = ReverseList(node1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        //新的头结点
        ListNode newHead = null;
        //当前遍历的节点
        ListNode pNode = head;
        //当前遍历的节点的前一个节点
        ListNode pPrev = null;

        while (pNode != null) {
            //当前遍历的节点的后一个节点
            ListNode pNext = pNode.next;
            //当只有一个节点时，新的头结点即为当前节点
            if (pNext == null) {
                newHead = pNode;
            }

            //将链表反转
            pNode.next = pPrev;
            pPrev = pNode;

            //为防止链表断裂，将写一个节点的值，保存下来
            pNode = pNext;
        }

        return newHead;

    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

