package com.zero.Review;

public class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }//构造函数

    public void add(Node node) {
        //添加节点的函数
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
    }

    public void addNode(int value) {
        if (head == null) {
            head = new Node(value);
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(value);
        }
    }

    public void delete(int value) {
        //删除指定值的节点的函数
        if (head == null) {
            return;//链表为空，直接返回。
        }
        if (head.value == value) {
            head = head.next;
            return;//要删除的节点就是头节点，直接将头节点指向下一个节点。
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value == value) {
                current.next = current.next.next;
                return;//如果找到了对应节点，就将当前节点的next指向下一个节点。
            }
            current = current.next;//没找到就往后继续找。
        }
    }

    public void print() {
        if (head == null) {
            return;//链表为空，直接返回。
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null");//链表的尾部的next都是null
    }
}

