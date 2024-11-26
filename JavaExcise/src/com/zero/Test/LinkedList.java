package com.zero.Test;

public class LinkedList {
    ListNode head;

    public LinkedList() {
        head = null;
    }

    /**
     * 添加节点
     *
     * @param value
     */
    public void addNode(int value) {
        if (head == null) {
            ListNode newnode = new ListNode(value);
            head = newnode;
        } else {
            ListNode newNode = new ListNode(value);
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * 遍历链表
     */
    public void PrintList() {
        if (head != null) {
            ListNode current = head;
            while (current != null) {
                System.out.print(current.value + "->");
                current = current.next;
            }
        }//如果链表为空，直接打印null，不为空则执行上面的打印。
        System.out.print("null");
    }

    /**
     * 获取链表的长度
     */

}
