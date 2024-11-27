package com.zero.Test;

public class BM8 {
    public static void main(String[] args) {
        linkedList list=new linkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.PrintList();
        System.out.println(getKToLast(list,4).value);
    }

    public static listNode getKToLastNode(linkedList list,int k){
        //获取链表中倒数第k个节点。
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode firstNode=DummyHead;
        int index=0;
        while(firstNode!=null&&index<k){
            firstNode=firstNode.next;
            index++;
        }//遍历找到第k个节点
        listNode secondNode=DummyHead;
        //如果链表长度小于k，firstNode为空，返回的secondNode就会是DummyHead，也就是0。
        while(firstNode!=null){
            firstNode=firstNode.next;
            secondNode=secondNode.next;
        }
        list.head=DummyHead.next;
        return secondNode;
    }

    public static listNode getKToLast(linkedList list,int k){
        //用第二种方法获取链表中的倒数第k个节点。
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode current=DummyHead;
        int length=0;
        while(current!=null){
            current=current.next;
            length++;
        }
        if(length<k){
            return DummyHead;
        }
        int index=0;
        current=DummyHead;
        while(index<length-k){
            current=current.next;
            index++;
        }
        return current;
    }
}
