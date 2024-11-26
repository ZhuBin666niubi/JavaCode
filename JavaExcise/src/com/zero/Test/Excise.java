package com.zero.Test;

public class Excise {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        list1.PrintList();
        ReversePartNode(list1,1,5);
        list1.PrintList();
    }

    /**
     * 删除链表中倒数第k个节点
     *
     * @param list
     * @param k
     */
    public static void DeleteKToLastNode(LinkedList list, int k) {
        //首先判断k的值是否有问题
        if(k<=0){
            return;
        }
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode current=DummyHead;
        int index=0;
        while(current!=null&&index<k){
            current=current.next;
            index++;
        }//先找到第k个节点。
        if(current==null){
            return;
        }//如果current为空，说明链表长度小于k，直接返回。然后就是，如果链表为空，也可以进入这个判断。所以不用再加判断。
        ListNode preNode=DummyHead;
        while(current.next!=null){
            preNode=preNode.next;
            current=current.next;
        }//将current移动到链表的末尾，preNode移动到倒数第k个节点的前一个节点。
        preNode.next=preNode.next.next;
        list.head=DummyHead.next;
    }

    /**
     * 删除链表中倒数第k个节点，我们设置一个虚拟的头节点，让虚拟的头节点指向原链表的头节点，
     * 使用两
     * @param list
     * @param k
     */
    /**
     *
     */
    public static void ReversePartNode(LinkedList list,int k,int m){
        //首先先判断一下k和m两个参数的值是否有问题
        if(k<=0||m<=0||k>=m){
            return;
        }
        ListNode DummyHead=new ListNode(0);//设置一个虚拟头节点
        DummyHead.next=list.head;
        ListNode current=DummyHead;
        int index=0;
        while(current!=null&&index<k){
            current=current.next;
            index++;
        }//找到第k个节点，然后进行反转操作
        if(current==null){
            return;
        }//如果current为空，说明链表长度小于k，直接返回。
        ListNode tempHead=current;
        ListNode markNode=current;
        ListNode nextNode=current.next;
        int count=0;//记录反转操作的次数
        while(nextNode!=null&&count<m-k){
            markNode.next=nextNode.next;
            nextNode.next=tempHead;
            tempHead=nextNode;
            nextNode=markNode.next;
            count++;
        }//实现反转操作
        if(count!=m-k){
            System.out.println("链表长度小于m");
            return;
        }//如果count不等于m-k，说明链表长度小于m，直接返回。
        //这里有个问题，就是链表长度小于m时，还是进行了一些操作的。会导致原来的链表发生变化。晚点思考怎么解决。
        ListNode preNode=DummyHead;
        index=0;
        while(index<k-1){
            preNode=preNode.next;
            index++;
        }//找到第k-1个节点，进行连接操作
        preNode.next=tempHead;
        list.head=DummyHead.next;
    }
}
