package com.zero.Test;

public class BM15 {
    public static void main(String[] args) {
        linkedList list=new linkedList();
        list.PrintList();
        deleteDuplicates(list);
        list.PrintList();
    }

    public static void deleteDuplicates(linkedList list){
        //删除链表中重复的节点。两种思路：用数组或者直接两指针法。
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode current=DummyHead.next;
        while(current!=null&&current.next!=null){
            if(current.next.value==current.value){
                current.next=current.next.next;
            }
            current=current.next;
        }
        list.head=DummyHead.next;
    }
}
