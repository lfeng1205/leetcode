package com.leetcode.sortList;

/**
 * Created by Feng on 2016/12/13.
 * <p>
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
public class SortList {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = sortList(node1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMiddleOfList(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return mergeSortList(left, right);
    }

    public static ListNode getMiddleOfList(ListNode head) {

        //用mid和high两个点找到中心点
        ListNode mid = head;
        ListNode high = head;

        while (high.next != null && high.next.next != null) {
            mid = mid.next;
            high = high.next.next;
        }

        return mid;
    }

    public static ListNode mergeSortList(ListNode left, ListNode right) {

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        ListNode head = null;

        if (left.val > right.val) {
            head = right;
            right = right.next;
        } else {
            head = left;
            left = left.next;
        }

        ListNode temp = head;

        while (right != null && left != null) {
            if (left.val > right.val) {
                temp.next = right;
                right = right.next;
            } else {
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
        }
        if (right != null) {
            temp.next = right;
        }
        if (left != null) {
            temp.next = left;
        }
        return head;
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
