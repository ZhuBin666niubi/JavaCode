package com.zero.Test;

public class BM7 {
    public static void main(String[] args) {
        linkedList list= new linkedList();
        listNode node1=new listNode(1);
        listNode node2=new listNode(2);
        listNode node3=new listNode(3);
        listNode node4=new listNode(4);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node2;
        list.head=node1;
        System.out.println(getCycleNode(list).value);
    }

    public static listNode getCycleNode(linkedList list){
        //获取链表中环的入口节点。
        listNode DummyNode=new listNode(0);
        DummyNode.next=list.head;
        listNode fastNode=DummyNode.next;
        listNode slowNode=DummyNode.next;
        while(fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode){
                break;
            }
        }
        if(fastNode==slowNode){
            fastNode=DummyNode.next;
            while(fastNode!=slowNode){
                fastNode=fastNode.next;
                slowNode=slowNode.next;
            }
            return fastNode;
        }
        return null;
    }
}
