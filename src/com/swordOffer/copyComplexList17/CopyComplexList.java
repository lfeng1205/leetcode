package com.swordOffer.copyComplexList17;

/**
 * Created by Feng on 2017/5/15.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CopyComplexList {
    public static void main(String[] args) {

    }

    public static RandomListNode copyComplexList(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        //当前节点
        RandomListNode pCurr = pHead;

        //复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
        while (pCurr != null) {
            RandomListNode pNode = new RandomListNode(pCurr.label);
            pNode.next = pCurr.next;
            pCurr.next = pNode;
            pCurr = pNode.next;
        }

        pCurr = pHead;

        //复制random pCur是原来链表的结点 pCur.next是复制pCur的结点
        while (pCurr != null) {
            if (pCurr.random != null) {
                pCurr.next.random = pCurr.random.next;
            }
            pCurr = pCurr.next.next;
        }

        RandomListNode newHead = pHead.next;
        RandomListNode newCurr = newHead;
        pCurr = pHead;

        //拆分链表
        while (pCurr != null) {
            pCurr.next = pCurr.next.next;
            if (newCurr.next != null) {
                newCurr.next = newCurr.next.next;
            }

            newCurr = newCurr.next;
            pCurr = pCurr.next;
        }
        return newHead;
    }
}

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}