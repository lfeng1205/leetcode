package com.swordOffer.firstCommonNodeInList28;

/**
 * Created by Feng on 2017/6/5.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FirstCommonNodeInList {
    public static void main(String[] args) {
        ListNode pHead1 = new ListNode(1);
        pHead1.next = new ListNode(2);
        pHead1.next.next = new ListNode(3);
        pHead1.next.next.next = new ListNode(6);
        pHead1.next.next.next.next = new ListNode(7);

        ListNode pHead2 = new ListNode(4);
        pHead2.next = new ListNode(5);
        pHead2.next.next = new ListNode(6);
        pHead2.next.next.next = new ListNode(7);

        ListNode result = findFirstCommonNode(pHead1, pHead2);
        System.out.println(result.val);
    }

    private static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode listNode1 = pHead1;
        ListNode listNode2 = pHead2;

        //获取每个链表的长度
        int length1 = getLength(pHead1);
        int length2 = getLength(pHead2);

        // 如果链表1的长度大于链表2的长度
        if (length1 > length2) {
            int length = length1 - length2;
            // 先遍历链表1，遍历的长度就是两链表的长度差
            while (length > 0) {
                listNode1 = listNode1.next;
                length--;
            }
        }

        // 如果链表2的长度大于链表1的长度
        if (length1 < length2) {
            int length = length2 - length1;
            // 先遍历链表2，遍历的长度就是两链表的长度差
            while (length > 0) {
                listNode2 = listNode2.next;
                length--;
            }
        }

        //开始齐头并进
        while ((listNode1.val != listNode2.val) &&
                (listNode1 != null) && (listNode2 != null)) {
            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }
        return listNode1;
    }

    private static int getLength(ListNode pHead) {

        int length = 0;
        ListNode current = pHead;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}