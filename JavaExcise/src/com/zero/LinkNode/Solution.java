package com.zero.LinkNode;

public class Solution {
    public static void main(String[] args) {

    }

    public RandomListNode copyRandomList(RandomListNode head) {//复制一个复制链表。
        //这里是我自己的想法，先直接复制一个链表，链表中的节点的random全部先不管，复制完之后，再遍历原链表，对应着将新链表
        //中的random指针赋值。
        if (head == null) {
            return null;
        }
        RandomListNode newHead = new RandomListNode(head.value);//设置一个新链表的头节点。
        newHead.next = null;
        RandomListNode current = head;
        RandomListNode newCurrent = newHead;
        while (current != null) {
            RandomListNode newNode = new RandomListNode(current.next.value);
            newNode.next = newCurrent.next;
            newCurrent = newNode;
            current = current.next;
        }//将原链表的节点复制到新链表上。
        current = head;
        newCurrent = newHead;
        while (current != null) {
            if (current.random != null) {
                newCurrent.random = current.random;
            }
            current = current.next;
            newCurrent = newCurrent.next;
        }//将原链表的random指针复制到新链表上。
        return newHead;
    }//写完代码之后，重新复盘逻辑，发现我的思路有了问题：复制链表之后，新链表中的random指针应该指向的是新链表中的节点，如果只是按照

    //原来的链表的random指针来指向，会发现新链表的random指针指向的是旧链表的节点。那么就需要想一想怎么实现将random的对应关系设置
    //好了。
    /*
    想法：循环遍历到原链表的random是存在的时候，我们就遍历原链表，同时遍历新链表，利用两个链表的节点一一对应，来找到新链表
    中random应该指向的地方。
    while(current!=null){
    if(current.random!=null){
    RandomListNode temp=head;
    RandomListNode newTemp=newHead;
    while(temp!=current.random){
    temp=temp.next;
    newTemp=newTemp.next;
    }
    }
    }
    这样就能找到对应的random指针。但是这个方法缺点非常明显，复制完链表需要遍历的次数太多了，时间复杂度很高。
     */
    public static RandomListNode copyRandomList2(RandomListNode head) {
        //思路：设置复制节点，然后分开两个链表即可。
        if(head==null){
            return null;
        }
        RandomListNode current=head;
        while(current!=null){
            RandomListNode copyNode=new RandomListNode(current.value);
            copyNode.next=current.next;
            current.next=copyNode;
            current=current.next.next;
        }//设置好了复制节点和复制节点的值
        while(current!=null){
            if(current.random!=null){
                current.next.random=current.random.next;
            }
            current=current.next.next;
        }
        current=head;
        RandomListNode newHead=head.next;
        RandomListNode newCurrent=newHead;
        while(current!=null){
            current.next=current.next.next;
            if(newCurrent.next!=null){
                newCurrent.next=newCurrent.next.next;
            }
            current=current.next;
            newCurrent=newCurrent.next;
        }
        return newHead;
    }
}
