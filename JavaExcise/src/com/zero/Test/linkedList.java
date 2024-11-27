package com.zero.Test;

public class linkedList {
    public listNode head;

    public linkedList() {
        head = null;
    }

    public linkedList(listNode head) {
        this.head = head;
    }

    /**
     * 添加节点
     *
     * @param value
     */
    public void addNode(int value) {
        if (head == null) {
            listNode newnode = new listNode(value);
            head = newnode;
        } else {
            listNode newNode = new listNode(value);
            listNode current = head;
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
            listNode current = head;
            while (current != null) {
                System.out.print(current.value + "->");
                current = current.next;
            }
        }//如果链表为空，直接打印null，不为空则执行上面的打印。
        System.out.println("null");
    }
}
