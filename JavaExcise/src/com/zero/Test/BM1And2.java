package com.zero.Test;

public class BM1And2 {
    public static void main(String[] args) {
        linkedList list=new linkedList();
        list.addNode(1);
        list.addNode(2);
        list.PrintList();
        ReversePart_R(list,1,2);
        list.PrintList();
    }

    /**
     * 具体的逻辑是：设置一个新的头节点，每次把原链表的头节点/或者说最前面的节点放到新的头节点前面，实时更新新的头节点和原
     * 头节点的位置，直到原头节点为空即可。
     * @param list
     */
    public static void ReverseList_A(linkedList list){
       //反转链表，除了说之前我们使用过的，在原链表的基础上，每次将头节点后的一个节点往最前面放，其实还有逻辑更为简单的双指针法。
        // 具体逻辑:每次把链表最前面的一个节点拆到新链表上，最后返回新链表。
        listNode newHead=null;
        while(list.head!=null){
            listNode tempNode=list.head.next;
            list.head.next=newHead;
            newHead=list.head;
            list.head=tempNode;
        }
        list.head=newHead;
    }

    public static void Reverse(linkedList list){
        //思路：将节点直接的指向依次逆转。
        listNode preNode=null;
        listNode nextNode=list.head;
        while(nextNode!=null){
            listNode tempNode=nextNode.next;
            nextNode.next=preNode;
            preNode=nextNode;
            nextNode=tempNode;
        }
        list.head=preNode;
    }

    public static void ReverseList_O(linkedList list){
        //自己原本的逻辑：在原链表上，每次把头节点后的一个节点往最前面放。
        listNode DummyNode=new listNode(0);
        DummyNode.next=list.head;
        listNode markNode=list.head;
        listNode markHead=list.head;
        listNode nextNode=list.head.next;
        while(nextNode!=null){
            markNode.next=nextNode.next;
            nextNode.next=markHead;
            markHead=nextNode;
            nextNode=markNode.next;
        }
        if(list.head==null){
            return;
        }
        list.head.next=null;
        list.head=markHead;
    }

    public static void ReversePartNode(linkedList list, int k, int m){
        if(k<=0||m<=0||k>=m){
            return;
        }
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode current=DummyHead;
        int index=0;
        while(current!=null&&index<k-1){
            current=current.next;
            index++;
        }//找到第k-1个节点。
        if(current==null){
            return;
        }
        listNode newHead=null;
        int count=0;
        listNode markHead=current.next;
        while(markHead!=null&&count<=m-k){
            listNode nextNode=markHead.next;
            markHead.next=newHead;
            newHead=markHead;
            markHead=nextNode;
            count++;
        }
        if(markHead==null&&count<m-k+1){
            System.out.println("链表长度小于m");
            return;
        }
        current.next=newHead;//如果这一句不写，事实上，current的next还是markHead，而此时的markHead应该指向的
        // 是第m+1个节点，所以就会导致结果出错。
        current=DummyHead;
        while(current.next!=null){
            current=current.next;
        }
        current.next=markHead;
        list.head=DummyHead.next;
    }

    public static void ReversePart(linkedList list, int k, int m){
        if(k<=0||m<=0||k>=m){
            return;
        }
        listNode DummyHead=new listNode(0);
        DummyHead.next=list.head;
        listNode current=DummyHead;
        int index=0;
        while(index<k-1&&current!=null){
            current=current.next;
            index++;
        }//找到第k-1个节点。
        if(current==null){
            return;
        }
        listNode markNode=current.next;
        listNode markHead=current.next;
        listNode nextNode=markNode.next;
        int count=0;
        while(nextNode!=null&&count<m-k){
            markNode.next=nextNode.next;
            nextNode.next=markHead;
            markHead=nextNode;
            nextNode=markNode.next;
            count++;
        }//实现反转操作
        if(nextNode==null&&count!=m-k){
            System.out.println("链表长度小于m");
            return;
        }
        current.next=markHead;
        list.head=DummyHead.next;
    }

    public static void ReversePart_R(linkedList list, int k, int m){
        if(k<=0||m<=0||k>=m){
            return;
        }
        listNode DummyNode=new listNode(0);
        DummyNode.next=list.head;
        int index=0;
        listNode current=DummyNode;
        while(current!=null&&index<k-1){
            current=current.next;
            index++;
        }//找到第k个节点的前置节点。
        listNode preNode=null;
        listNode nextNode=current.next;
        int count=0;
        while(nextNode!=null&&count<=m-k){
            listNode tempNode=nextNode.next;
            nextNode.next=preNode;
            preNode=nextNode;
            nextNode=tempNode;
            count++;//别老是忘记写这种++的语句啊！
        }
        if(nextNode==null&&count<m-k){
            System.out.println("链表的长度小于m");
            return;
        }
        current.next=preNode;
        current=DummyNode;
        while(current.next!=null){
            current=current.next;
        }
        current.next=nextNode;
        list.head=DummyNode.next;
    }
}
