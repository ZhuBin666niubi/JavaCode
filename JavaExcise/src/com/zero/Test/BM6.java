package com.zero.Test;

import com.zero.Review.LinkedList;

public class BM6 {
    public static void main(String[] args) {
        linkedList list= new linkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        listNode current=list.head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=list.head;
        System.out.println(hasCycle(list));
    }

    public static Boolean hasCycle(linkedList list){
        //判断链表中是否有环。
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode fastNode=DummyHead.next;
        listNode slowNode=DummyHead.next;
        while(fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode){
                return true;
            }
        }
        return false;
    }

}
