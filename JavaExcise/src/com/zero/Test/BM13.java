package com.zero.Test;

public class BM13 {
    public static void main(String[] args) {
        linkedList list=new linkedList();
        list.addNode(2);
        list.addNode(1);
        list.PrintList();
        boolean result=isPail(list);
        System.out.println(result);
    }

    public static boolean isPail(linkedList list){
        //两种思路：要么就从中间截开，然后比较，要么就用数组存储，然后在数组中进行判断。
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode current=DummyHead;
        int length=0;
        while(current!=null){
            current=current.next;
            length++;
        }
        int arr[]=new int[length];
        current=DummyHead;
        for(int index=0;index<length;index++){
            arr[index]=current.value;
            current=current.next;
        }
        int count=0;
        int index=1;
        while(count<length/2){
            if(arr[index]!=arr[length-index]){
                return false;
            }
            index++;
            count++;
        }
        return true;
    }//这里有一个方法值得参考：将后半部分的链表进行逆转，然后比较。
}
