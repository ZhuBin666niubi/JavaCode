package com.zero.LinkNode;

public class Test {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.print();
        Node result=getNode(list,7);
        System.out.println(result.data);
    }
    public static Node getNode(LinkedList list,int k){
        //题目描述：输入一个长度为n的链表，设链表中的元素为ai，返回该表中倒数第k个节点。
        int length=0;
        if(list.head==null){
            return null;
        }else{
            length=1;
            Node current=list.head;
            while(current.next!=null){
                current=current.next;
                length++;
            }
        }//先得到链表的长度。
        if(k>length){
            return null;
        }else{
            //如果length>=k,那么我们就可以开始寻找倒数第k个节点。
            int index=0;
            Node current=list.head;
            while(index+k!=length){
                current=current.next;
                index++;
            }
            Node result=current;
            return result;
        }
    }
}
