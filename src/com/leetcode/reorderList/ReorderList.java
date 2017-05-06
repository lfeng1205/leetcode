package com.leetcode.reorderList;

/**
 * Created by Feng on 2016/12/15.
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * You must do this in-place without altering the nodes' values.
 * <p>
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}
 */
public class ReorderList {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        reorderList(node1);
        while (node1 != null) {
            System.out.print(node1.val + " ");
            node1 = node1.next;
        }
    }

    /**
     * 先用快慢指针找到链表的中点，然后翻转链表后半部分，再和前半部分组合。
     * 需要注意的是把链表分成两半时，前半段的尾节点要置为NULL，翻转链表时也要把尾节点置为NULL。
     *
     * @param head
     */
    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        //把整个链表划分成2个等长的子链表，如果原链表长度为奇数，那么第一个子链表的长度多1
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
            } else {
                break;
            }
            slow = slow.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;

        //翻转第二个子链表
        ListNode curr = head2, post = curr.next;
        curr.next = null;
        while (post != null) {
            ListNode tmp = post.next;
            post.next = curr;
            curr = post;
            post = tmp;
        }

        head2 = curr;

        //将两个子链表合并
        ListNode node1 = head1, node2 = head2;
        while (node2 != null) {
            ListNode tmp1 = node1.next;
            ListNode tmp2 = node2.next;
            node1.next = node2;
            node2.next = tmp1;
            node1 = tmp1;
            node2 = tmp2;
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
