package com.zero.LinkNode;

public class LinkedList {//为了锻炼代码思维，我们先来学习一下链表以及链表的一些基本操作。
    //链表由节点组成，每个节点包含两个部分，数据域和指针域。数据域存放节点所代表的数据，指针域存放下一个节点的地址。
    Node head;//头节点，链表的起始点。
    public LinkedList(){//构造方法，初始化链表。
        this.head=null;
    }//这个函数的意义是创建一个空的链表，初始化头结点。
    public void addNode(int data){
        //想要在链表中加入一个指定值的节点，那我们先声明一个新的节点。
        Node newNode=new Node(data);
        //然后我们开始实现加入新节点的操作。首先来看临界条件：
        //如果，这个链表是一个空链表，那么我们把newNode作为头节点，直接返回。
        if(head==null){
            head=newNode;
            return;
        }
        else{
            //否则，我们就先找到链表的末尾，将链表的尾部节点的next指向新节点。
            Node current=head;
            while(current.next!=null){
                current=current.next;
            }//往后找链表的尾部节点。
            current.next=newNode;
        }
    }//这就完成了在链表末尾加入链表的操作。
    public void remote(int data){
        //现在我们要删除指定值的节点，那么好，我们先来看临界条件。
        if(head==null){
            return;//如果链表的头节点为空，说明链表中根本没有节点，那么就不用删除。
        }else{
            if(head.data==data){
                head=head.next;
                return;
            }//这个情况被我们遗漏了，需要注意的是，头节点就是我们要删除的节点的话，情况是特殊的。如果头节点是要删除的节点，更换头节点为下一个节点即可。
            //不然，我们就需要找到对应值的节点，将它删除。我们先来找到它。
            Node current=head;
            while(current.next!=null&&current.data!=data){
                current=current.next;//如果没有遍历到最后一个节点，或者节点的值不是我们要找的值，那我们就向后遍历，寻找对应节点。
            }
            //如果我们找到了对应节点，我们就将其删除。
            if(current.next!=null){
                current.next=current.next.next;
                return;
            }
        }
    }
    public void print(){
        //现在我们来学习遍历一个链表。还是一样，我们先看特殊情况，临界条件。
        Node current=head;
        while(current!=null){
            System.out.println(current.data+"->");
            current=current.next;
        }
        System.out.println("null");
    }//这样我们就完成了遍历一个链表的操作。在实现这个遍历操作的时候，我们习惯性考虑了临界条件，但是写完之后发现，这些临界条件
    //其实是包含在while循环中的，我们不必再单独考虑。所以写代码还是不要有惯性思维，先考虑再写，写完要实践。

}
