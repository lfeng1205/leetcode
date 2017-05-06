package com.leetcode.addTwoNumbers;

/**
 * Created by Feng on 2016/12/1.
 * You are given two linked lists representing two non-negative numbers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode pNode = head;

        int temp = 0;

        while (l1 != null || l2 != null || temp != 0) {
            if (l1 != null) {
                temp += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                temp += l2.val;
                l2 = l2.next;
            }

            pNode.next = new ListNode(temp % 10);
            pNode = pNode.next;

            //如果temp小于10,则将temp置0;如果temp大于等于10,则向后进位
            temp = temp / 10;
        }

        return head.next;
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