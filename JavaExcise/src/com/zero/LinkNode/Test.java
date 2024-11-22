package com.zero.LinkNode;

public class Test {
    public static void main(String[] args) {
        LinkedList list=new LinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(9);
        list.addNode(6);
        list.addNode(7);
        list.addNode(10);
        ReverseList(list);
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
    public static Node getNode_new(LinkedList list,int k){
        //现在我们尝试用一种新的方法来解决获取链表的倒数第k个节点。
        //整体思路是，我们设置两个节点，一个节点先出发，一个后出发，先出发的走了k步之后，后出发的开始走
        //当先出发的到达最后一个节点的时候，应该走了链表的总体长度-k步，所以后出发的节点应该刚好到达倒数第k个节点。
        Node firstnode=list.head;
        Node secondnode=list.head;
        int length=list.getLenth();
        if(k>length){
            return null;
        }else{
            int index=1;//记录firstnode当前所在位置
            while(index<k){
                firstnode=firstnode.next;
                index++;
            }//让firstnode先走k-1步,到达第k个节点。
            while(firstnode.next!=null){
                firstnode=firstnode.next;
                secondnode=secondnode.next;
            }//让两个节点同时出发，当firstnode到达最后一个节点的时候，secondnode就到达了倒数第k个节点。
            Node result=secondnode;
            return result;
        }//写代码，先确定自己要解决这个问题的思路，再确定我们需要使用的变量等等，然后再开始使用代码来实际解决问题。
    }
    public static Node CycleNode(LinkedList list){
        //现在来学习怎么获取链表中的环的入口节点。这个我自己是没有想到解决办法的，找ai要了解题思路，现在来自己尝试写代码。
        //要获取链表中的环的入口节点，首先我们要判断这个链表到底是不是有环的。
        if(list.head==null||list.head.next==null){
            return null;//如果链表中只有一个节点或者没有节点，都不可能有环。只有一个节点也没环是我没考虑到的。
        }else{
            Node fastnode=list.head;
            Node slownode=list.head;
            while(fastnode!=slownode&&fastnode.next!=null){
                fastnode=fastnode.next.next;
                slownode=slownode.next;
            }
            if(fastnode==null||fastnode.next==null){//这里的判断，不能忽略fastnode==null。
                return null;
            }else{
                fastnode=list.head;
                while(fastnode!=slownode){
                    fastnode=fastnode.next.next;
                    slownode=slownode.next;
                }
                Node result=slownode;
                return result;
            }
        }
    }
    public static void ReversePrint(LinkedList list){
        //现在来学习怎么逆序打印一个链表。我的想法是，创建一个新的链表，然后把原链表的节点一个个逆向连接到新的链表中。
        if(list.head==null||list.head.next==null){
            System.out.println(list.head.data);
        }else{
            LinkedList list_new=new LinkedList();
            Node current=list.head;
            list_new.addNode(current.data);//这个代码还是要了解清楚。
            while(current!=null){
                Node newnode=new Node(current.data);
                newnode.next=list_new.head.next;
                list_new.head.next=newnode;
                current=current.next;
            }
            list_new.head=list_new.head.next;
            Node current_new=list_new.head;
            while(current_new!=null){
                System.out.println(current_new.data);
                current_new=current_new.next;
            }
        }
    }
    public static void ReverseList(LinkedList list){
        //现在我们尝试用另外一种方法来反序打印链表。
        if(list.head==null||list.head.next==null){
            System.out.println(list.head.data);
        }else{
            Node prenode=list.head;
            Node tempnode=prenode.next;
            while(tempnode!=null){
                prenode.next=tempnode.next;
                tempnode.next=list.head;
                list.head=tempnode;
                tempnode=prenode.next;
            }//每次我们把head后面的一个节点插入到最前面，循环完成之后就完成了反转链表的操作。
            //接下来我们来打印链表。
            Node current=list.head;
            while(current!=null){
                System.out.println(current.data);
                current=current.next;
            }
        }
    }
    public static Node PublicNode(LinkedList list1,LinkedList list2){
        //现在我们来看看怎么寻找两个链表的公共节点。
        //思路是，让两个节点分别从头部出发，当某一个节点到达链表尾部时，就从另外一个链表的头部开始走，当两个current遍历节点
        //相同时，说明这个就是公共节点。如果一直不同说明不存在公共节点。
        if(list1.head==null||list2.head==null){
            return null;
        }
        Node current1=list1.head;
        Node current2=list2.head;
        while(current1!=current2){
            current1=current1.next;
            current2=current2.next;
            if(current1==null){
                current1=list2.head;
            }
            if(current2==null){
                current2=list1.head;
            }
        }
        if(current1!=null){
            Node result=current1;
            return result;
        }
        else{
            return null;
        }
    }
    public static void DeleteRepeatNode(LinkedList list){
        //现在来学习怎么删除链表中的重复节点。
        Node current=list.head;
        while(current!=null){
            Node temp=current;
            while(temp.next!=null){
                if(temp.next.data== current.data){
                    temp.next=temp.next.next;
                }else{
                    temp=temp.next;
                }
            }
            current=current.next;
        }
    }
}
