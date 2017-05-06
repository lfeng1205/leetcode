package com.leetcode.insertionSortList;

/**
 * Created by Feng on 2016/12/13.
 * Sort a linked list using insertion sort.
 */
public class InsertionSortList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = insertionSortList(node1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode sortHead = new ListNode(-1);
        while (head != null) {
            ListNode temp = head.next;
            ListNode curr = sortHead;

            //对值的大小进行比较
            while (curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }

            //插入s
            head.next = curr.next;
            curr.next = head;
            
            //恢复head
            head = temp;
        }

        return sortHead.next;
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
