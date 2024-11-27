package com.zero.Test;

public class BM10 {
    public static void main(String[] args) {
        // 创建链表1
        linkedList list1 = new linkedList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        // 创建链表2
        linkedList list2 = new linkedList();
        list2.addNode(4);
        list2.addNode(5);
        // 创建公共节点
        listNode commonNode = new listNode(6);
        list1.head.next.next.next = commonNode;
        list2.head.next.next = commonNode;
        // 添加更多节点
        commonNode.next = new listNode(7);
        commonNode.next.next = new listNode(8);
        // 调用 getPublicNode 方法
        listNode publicNode = getPubNode(list1, list2);
        linkedList list3=new linkedList();
        linkedList list4=new linkedList();
        listNode pubNode=getPubNode(list3,list4);
        // 输出结果
        if (publicNode != null) {
            System.out.println("公共节点值: " + publicNode.value);
        } else {
            System.out.println("没有公共节点");
        }
        System.out.println(pubNode.value);
    }

    public static listNode getPublicNode(linkedList list1,linkedList list2){
        listNode DummyHead1=new listNode(0);
        DummyHead1.next=list1.head;
        listNode DummyHead2=new listNode(0);
        DummyHead2.next=list2.head;
        listNode current1=DummyHead1;
        listNode current2=DummyHead2;
        while(current1!=current2){
            if(current1.next==null){
                current1=DummyHead2;
            }
            if(current2.next==null){
                current2=DummyHead1;
            }
            current1=current1.next;
            current2=current2.next;
        }
        if(current1==null){
            System.out.println("无公共节点。");
            return null;
        }
        return current1;
    }

    public static listNode getPubNode(linkedList list1,linkedList list2){
        listNode DummyHead1=new listNode(0);
        DummyHead1.next=list1.head;
        listNode DummyHead2=new listNode(0);
        DummyHead2.next=list2.head;
        int len1=0;
        int len2=0;
        listNode current1=DummyHead1;
        listNode current2=DummyHead2;
        while(current1!=null){
            current1=current1.next;
            len1++;
        }
        while(current2!=null){
            current2=current2.next;
            len2++;
        }
        current1=DummyHead1;
        current2=DummyHead2;
        if(len1>len2){
            for(int index=0;index<len1-len2;index++){
                current1=current1.next;
            }
            while(current1!=current2){
                current1=current1.next;
                current2=current2.next;
            }
            if(current1==null){
                return DummyHead1;
            }
            return current1;
        }else{
            for(int index=0;index<len2-len1;index++){
                current2=current2.next;
            }
            while(current1!=current2){
                current1=current1.next;
                current2=current2.next;
            }
            if(current1==null){
                return DummyHead2;
            }
            return current1;
        }
    }
}
