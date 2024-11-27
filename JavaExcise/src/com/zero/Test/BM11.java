package com.zero.Test;

public class BM11 {
    public static void main(String[] args) {
        linkedList list1=new linkedList();
        linkedList list2=new linkedList();
        list2.addNode(1);
        list2.addNode(2);
        list2.addNode(3);
        listNode result=addList(list1, list2);
        while(result!=null){
            System.out.print(result.value);
            result=result.next;
        }
    }

    public static listNode addList(linkedList list1,linkedList list2)
    {
        //链表相加。
        listNode preNode1=null;
        listNode curNode1= list1.head;
        while(curNode1!=null){
            listNode tempNode1=curNode1.next;
            curNode1.next=preNode1;
            preNode1=curNode1;
            curNode1=tempNode1;
        }
        list1.head=preNode1;
        list1.PrintList();
        listNode preNode2=null;
        listNode curNode2= list2.head;
        while(curNode2!=null){
            listNode tempNode2=curNode2.next;
            curNode2.next=preNode2;
            preNode2=curNode2;
            curNode2=tempNode2;
        }//对两个链表执行链表翻转。
        list2.head=preNode2;
        list2.PrintList();
        listNode DummyHead=new listNode(0);
        curNode1=list1.head;
        curNode2=list2.head;
        boolean carry=false;
        int result=0;
        while(curNode1!=null&&curNode2!=null){
            if(curNode1.value<0||curNode1.value>9||curNode2.value<0||curNode2.value>9){
                System.out.println("链表中存在非法节点");
                return null;
            }
            result=curNode1.value+curNode2.value+(carry?1:0);
            if(result>=10){
                carry=true;
                result-=10;
            }else{
                carry=false;
            }
            listNode resultNode=new listNode(result);
            resultNode.next=DummyHead.next;
            DummyHead.next=resultNode;
            curNode1=curNode1.next;
            curNode2=curNode2.next;
        }
        if(curNode1==null){
            while(curNode2!=null){
                if(curNode2.value<0||curNode2.value>9){
                    System.out.println("链表中存在非法节点");
                    return null;
                }
                result=curNode2.value+(carry?1:0);
                if(result>=10){
                    carry=true;
                    result-=10;
                }else{
                    carry=false;
                }
                listNode resultNode=new listNode(result);
                resultNode.next=DummyHead.next;
                DummyHead.next=resultNode;
                curNode2=curNode2.next;
            }
        }
        if(curNode2==null){
            while(curNode1!=null){
                if(curNode1.value<0||curNode1.value>9){
                    System.out.println("链表中存在非法节点");
                    return null;
                }
                result=curNode1.value+(carry?1:0);
                if(result>=10){
                    carry=true;
                    result-=10;
                }else{
                    carry=false;
                }
                listNode resultNode=new listNode(result);
                resultNode.next=DummyHead.next;
                DummyHead.next=resultNode;
                curNode1=curNode1.next;
            }
            if(carry){
                listNode resultNode=new listNode(1);
                resultNode.next=DummyHead.next;
                DummyHead.next=resultNode;
            }
        }
        return DummyHead.next;
    }
}
