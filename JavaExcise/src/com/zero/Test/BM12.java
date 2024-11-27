package com.zero.Test;

import java.util.Arrays;

public class BM12 {
    public static void main(String[] args) {
        linkedList list=new linkedList();
        list.addNode(7);
        list.addNode(3);
        list.addNode(2);
        list.addNode(5);
        list.addNode(4);
        list.PrintList();
        ListSort(list);
        list.PrintList();
        //记得好好学习一下归并排序。
    }

    public static void listSort(linkedList list){
        listNode DummyNode=new listNode(0);
        DummyNode.next=list.head;
        listNode current=DummyNode.next;
        while(current!=null){
            listNode nextNode=current.next;
            while(nextNode!=null){
                if(current.value>nextNode.value){
                    int temp=current.value;
                    current.value=nextNode.value;
                    nextNode.value=temp;
                }
                nextNode=nextNode.next;
            }
            current=current.next;
        }
        list.head=DummyNode.next;
    }

    public static void ListSort(linkedList list){
        listNode DummyNode=new listNode(0);
        DummyNode.next=list.head;
        listNode current=DummyNode;
        int length=0;
        while(current!=null){
            current=current.next;
            length++;
        }//获取链表的长度
        int arr[]=new int[length];
        current=DummyNode;
        for(int index=0;index<length;index++){
            arr[index]=current.value;
            current=current.next;
        }
        Arrays.sort(arr);
        current=DummyNode.next;
        for(int index=1;index<length;index++){
            current.value=arr[index];
            current=current.next;
        }
        list.head=DummyNode.next;
    }
}
