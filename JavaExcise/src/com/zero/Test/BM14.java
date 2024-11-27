package com.zero.Test;

public class BM14 {
    public static void main(String[] args) {
        linkedList list=new linkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        list.addNode(6);
        list.addNode(7);
        list.PrintList();
        listNode newHead=oddEvenList(list);
        while (newHead!=null){
            System.out.println(newHead.value);
            newHead=newHead.next;
        }
    }

    /**
     * 建议用两个链表的方法写的时候，要好好研究偶数节点是最后一个节点的情况和奇数节点是最后一个节点的情况。
     * @param list
     * @return
     */
    public static listNode oddEvenList(linkedList list){
        //将一个链表分为奇数节点和偶数节点进行排列。
        //思路：第一：用数组；第二：用两个链表。
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode oddNode=DummyHead.next;
        listNode evenNode=DummyHead.next.next;
        listNode newHead=evenNode;
        while(oddNode!=null&&evenNode!=null){
            oddNode.next=evenNode.next;
            if(evenNode.next!=null) {
                evenNode.next = evenNode.next.next;
            }
            oddNode=oddNode.next;
            evenNode=evenNode.next;
        }//当偶数节点的下一个节点为空，就说明偶数节点是最后一个节点，我们把偶数链表的最后一个节点的next置空，然后连接即可。
        //偶数节点的下一个节点不是null的话，说明奇数节点才是最后一个节点，evenNode就可以遍历到null，然后结束循环，连接即可。
        if(oddNode!=null){
            oddNode.next=newHead;//当偶数节点为空，那我们直接把两个链表连接起来就像。
        }else{
            oddNode=DummyHead.next;
            while(oddNode.next!=null){
                oddNode=oddNode.next;
            }
            oddNode.next=newHead;//奇数遍历到最后一个节点为空，那我们把奇数链表连接到偶数链表的末尾。
        }//这一段再看看。
        return DummyHead.next;
    }
}
