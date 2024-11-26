package com.zero.Review;

public class LinkedList {
    //头结点
    ListNode head;

    public LinkedList() {
        this.head = null;
    }//构造函数

    public LinkedList(ListNode head) {
        this.head = head;
    }
    public void addNode(int value) {
        //现在来设计一个方法，向链表中添加一个节点。
        if (head == null) {
            ListNode newnode = new ListNode(value);
            head = newnode;
        } else {//这里一定要加else，如果不加else，那么第一次添加节点的时候，会添加两次。
            ListNode newNode = new ListNode(value);
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void deleteNode(int value) {
        //设计删除指定值的节点的方法
        if (head == null) {
            return;
        }//如果链表为空，直接返回。
        if (head.value == value) {
            head = head.next;
            return;
        }//如果要删除的节点就是头节点，就直接将头结点向后移动一位。
        ListNode current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
        return;
    }

    public void printList() {
        if (head != null) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.value + "->");
                current = current.next;
            }
        }
        System.out.print("null");
    }//实现从头结点开始遍历链表的方法。

    public int getLength() {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}