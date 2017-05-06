package com.swordOffer.printListFromTailToHead03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Feng on 2017/5/1.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
public class PrintListFromTailToHead {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        printListFromTailToHead2(node1);
    }

    //利用栈
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<Integer>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }
        return arrayList;
    }

    //利用递归
    private static void printListFromTailToHead2(ListNode pHead) {
        if (pHead != null) {
            if (pHead.next != null) {
                printListFromTailToHead2(pHead.next);
            }
            System.out.print(pHead.val + " ");
        }

    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
