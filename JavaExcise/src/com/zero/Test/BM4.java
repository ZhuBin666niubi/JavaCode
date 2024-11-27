package com.zero.Test;

public class BM4 {
    public static void main(String[] args) {
        linkedList list1=new linkedList();
        list1.addNode(1);
        list1.addNode(3);
        list1.addNode(5);
        linkedList list2=new linkedList();
        list2.addNode(2);
        list2.addNode(4);
        list2.addNode(6);
        listNode result=Merge(list1, list2);
        while(result!=null){
            System.out.println(result.value);
            result=result.next;
        }
    }

    public static listNode Merge(linkedList list1, linkedList list2){
        //合并两个排序的链表
        listNode DummyNode=new listNode(0);
        listNode current1=list1.head;
        listNode current2=list2.head;
        listNode markNode=DummyNode;
        while(current1!=null&&current2!=null){
            if(current1.value<=current2.value){
                markNode.next=current1;
                markNode=current1;
                current1=current1.next;
            }else{
                markNode.next=current2;
                markNode=current2;
                current2=current2.next;
            }
        }
        if(current1==null){
            while(current2!=null){
                markNode.next=current2;
                markNode=current2;
                current2=current2.next;
            }
        }
        if(current2==null){
            while(current2!=null){
                markNode.next=current1;
                markNode=current1;
                current1=current1.next;
            }
        }
        return DummyNode.next;
    }
}
