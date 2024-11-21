package com.zero.LinkNode;

public class Review {
    public static void main(String[] args) {

    }
    //今天来复习一下之前学的有关链表的一些代码。
    /*
    首先我们要知道链表是什么，关于链表，我们可以理解为节点的线性表，而节点的结构是存储数据和下一个节点的位置，也就是data和next。
    链表呢，会有一个头节点，初始化链表就是把头节点置空。构造节点，就是把节点的data存储对应的数据，然后把next置空。
     */
    //我们先来看怎么往一个链表中添加元素。
    public static void addNode(LinkedList list,int data){
        //要往链表中添加元素，要么就是往链表的尾部放一个节点，要么就是往链表的头部放一个节点。
        //我们先来看看尾部添加节点。
        Node newnode=new Node(data);
        if(list.head==null){
            list.head=newnode;
        }else{
            Node current=list.head;
            while(current.next!=null){
                current=current.next;
            }//遍历链表，找到链表的尾部。
            newnode.next=current.next;
            current.next=newnode;//将新节点插入链表尾部。
        }
        //现在我们来看看头插法。
        if(list.head==null){
            list.head=newnode;
        }else{
            newnode.next=list.head;
            list.head=newnode;
        }
    }
    public static void RemoteNode(LinkedList list,int data){
        //要删除一个对应值的节点，逻辑当然是找到它再删掉它。
        if(list.head==null){
            return;//如果链表为空，那就直接返回。
        }else{
            Node current=list.head;
            while(current.next.next!=null&&current.next.data!=data){
                current=current.next;
            }
            if(current.next.next!=null){
                current.next=current.next.next;
                return;
            }else{
                return;
            }
        }
    }
    public static void ReversePrint(LinkedList list){
        //现在来复习反向打印链表元素。
        //脑子里浮现的是两种方法，第一，将链表逆转，然后遍历逆转之后的链表，第二，声明一个新链表，把原链表的数据反向存储到
        //新链表中，然后遍历新链表。
        if(list.head==null){
            return;
        }
        if(list.head.next==null){
            System.out.println(list.head.data);
        }
        //我们先来试试逆转链表。我们设置一个标记节点，用来标记原链表的头节点，我们每次把头节点后面的一个节点放置到头节点前面，
        //然后我们把头节点前面的节点设置为新的头节点，这样循环往复，直到标记的原头节点的下一个节点为null，就可以结束循环。
        Node marknode=list.head;
        Node tempnode=marknode.next;
        while(marknode.next!=null){
            marknode.next=tempnode.next;
            tempnode.next=list.head;
            list.head=tempnode;
            tempnode=marknode.next;
        }
        Node current=list.head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }
    public static void getNode(LinkedList list,int k){
        //获取倒数第k个节点。
        //第一种方法，先获取链表的长度，然后将链表的长度减去k，然后遍历链表，找到对应的节点。
        if(list.head==null){
            return;
        }
        int length=list.getLenth();
        if(k<=0||k>length){
            return;
        }else{
            Node current=list.head;
            for(int i=1;i<length-k+1;i++){
                current=current.next;
            }
            System.out.println(current.data);
        }
        //第二种方法，设置两个节点，一个先出发，走k步，然后两个节点一起出发，当第一个节点到达时，第二个节点所在位置就是
        //倒数第k个节点。
        Node firstnode=list.head;
        Node secondnode=list.head;
        for(int i=1;i<k;i++){
            firstnode=firstnode.next;
        }//这里firstnode就会到达第k个节点。
        while(firstnode.next!=null){
            firstnode=firstnode.next;
            secondnode=secondnode.next;
        }
        System.out.println(secondnode.data);
    }
    public static Node CycleNode(LinkedList list){
        //现在我们来试试判断链表是否是循环链表，并且将循环节点找出来。
        if(list.head==null){
            return null;
        }
        Node fastnode=list.head;
        Node slownode=list.head;
        while(fastnode!=null&&fastnode.next!=null||fastnode==slownode){
            fastnode=fastnode.next.next;
            slownode=slownode.next;
        }
        if(fastnode==slownode){
            fastnode=list.head;
            while(fastnode!=slownode){
                fastnode=fastnode.next.next;
                slownode=slownode.next;
            }
            return slownode;
        }
        return null;
    }
}
