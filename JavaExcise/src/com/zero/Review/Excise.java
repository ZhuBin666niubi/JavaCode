package com.zero.Review;

public class Excise {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.addNode(1);
        list1.addNode(2);
        list1.addNode(3);
        list1.addNode(4);
        list1.addNode(5);
        LinkedList list2 = new LinkedList();
        list2.addNode(2);
        list2.addNode(3);
        list2.addNode(6);
        list2.addNode(7);
        list2.addNode(8);
    }

    public static void ReversePrint(LinkedList list) {
        //设计一个方法，实现反向打印链表。
        //第一种思路：设置一个新链表，用头插法将链表的节点插入到新链表中，最后打印新链表。
        if (list.head == null || list.head.next == null) {
            list.printList();
        }//如果链表为空或者链表中只有一个节点，那就直接打印
        ListNode current = list.head;
        LinkedList newList = new LinkedList();
        while (current != null) {
            ListNode tempnode = new ListNode(current.value);
            tempnode.next = newList.head;
            newList.head = tempnode;
            current = current.next;
        }//这样就实现了头插法设置新链表。
        newList.printList();// 或者这里也可以直接从newHead开始遍历打印。
    }

    public static void ReversePrintList(LinkedList list) {
        //第二种思路：原地逆转链表之后打印
        if (list.head == null || list.head.next == null) {
            list.printList();
        }//如果链表为空或者链表只有一个元素，那么就直接打印即可。
        //原地逆置链表需要两个辅助节点，marknode和tempnode，mark记录链表原来的头部，temp记录链表原来的头部的下一个节点。
        //我们每次把链表头节点后的节点放在链表的第一个位置，并且实时更新头节点，就可以把链表逆转。
        ListNode markNode = list.head;
        ListNode tempNode = list.head.next;
        while (tempNode != null) {
            markNode.next = tempNode.next;
            tempNode.next = list.head;
            list.head = tempNode;
            tempNode = markNode.next;
        }//实现逆转
        list.printList();
    }

    public static ListNode GetKToLastNode(LinkedList list, int k) {
        //获取链表中的倒数第k个节点。
        //第一个思路：直接遍历链表，获取链表的总体长度，然后遍历链表，找到第length-k+1个节点。
        if (list.head == null) {
            return null;
        }
        int lenth = 1;
        ListNode current = list.head;
        while (current.next != null) {
            current = current.next;
            lenth++;
        }//得到链表的总体长度
        if (k > lenth) {
            return null;
        } else {
            current = list.head;
            for (int times = 1; times <= lenth - k; times++) {
                current = current.next;
            }
            return current;
        }//获取倒数第k个节点。
    }

    public static ListNode GetkToLastNode(LinkedList list, int k){
        //第二种思路：设置两个节点，一个先出发，走到第k个节点，然后两个节点一起出发，当第一个节点到达链表尾部，第二个节点
        //所在位置就是倒数第k个节点。
        if(list.head==null){
            return null;
        }
        ListNode firstNode = list.head;
        ListNode secondNode = null;
        int index=1;
        while(firstNode!=null&&index<k){
            firstNode=firstNode.next;
            index++;
        }//第一个节点先出发走到第k个节点的位置。
        if(firstNode!=null){
            secondNode=list.head;
        }//如果链表长度大于k，那么secondNode就为null。
        while(firstNode.next!=null){
            firstNode=firstNode.next;
            secondNode=secondNode.next;
        }
        return secondNode;
    }//方法都存在的问题是，当不符合条件的时候，会直接报错。

    public static ListNode FindCycleEntry(LinkedList list){
        //寻找环的入口节点。思路是：设置快慢两个节点，快节点的速度是慢节点的两倍，当快慢节点相遇，说明链表中是有环的，
        //相遇的时候，快节点肯定是比慢节点多跑了一圈，此时我们把快节点或者慢节点设置回头节点，然后两个节点一起出发，两个节点
        //以同样的速度出发，相遇的时候就是环的入口节点。
        if(list.head==null||list.head.next==null){
            return null;
        }
        ListNode fastNode=list.head;
        ListNode slowNode=list.head;
        while(fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode){
                break;
            }
        }//找到相遇点
        if(fastNode==null||fastNode.next==null){
            return null;
        }
        slowNode=list.head;
        while(slowNode!=fastNode){
            slowNode=slowNode.next;
            fastNode=fastNode.next;
        }
        return slowNode;
    }

    public static ListNode MergeList(LinkedList list1,LinkedList list2){
        //思路：如果某一个链表为空，就直接返回链表。都不为空的话，我们设置一个虚拟的头节点，然后
        //遍历找较小的节点，以此构建新的链表。
        if(list1.head==null){
            return list2.head;
        }
        if(list2.head==null){
            return list1.head;
        }
        ListNode newHead=new ListNode(0);
        ListNode current1=list1.head;
        ListNode current2=list2.head;
        ListNode marknode=newHead;
        while(current1!=null&&current2!=null){
            if(current1.value<current2.value){
                marknode.next=current1;
                marknode=current1;
                current1=current1.next;
            } else{
                marknode.next=current2;
                marknode=current2;
                current2=current2.next;
            }
        }
        if(current1==null){
            while(current2!=null){
                marknode.next=current2;
                marknode=current2;
                current2=current2.next;
            }
        }
        if(current2==null){
            while(current1!=null){
                marknode.next=current1;
                marknode=current1;
                current1=current1.next;
            }
        }
        newHead=newHead.next;
        return newHead;
    }//需要注意的是，我们只是连接链表，对于链表中的节点是不做过多改变的。

    public static void DeleteRepeatedNode(LinkedList list){
        //删除链表中的重复节点。这里的链表是有序的。
        if(list.head==null||list.head.next==null){
            return;
        }
        ListNode current=list.head;
        while(current.next!=null){
            if(current.value==current.next.value){
                current.next=current.next.next;
            } else{
                current=current.next;
            }
        }
    }

    public static ListNode PublicNode(LinkedList list1,LinkedList list2){
        //寻找两个链表的公共节点。
        if(list1.head==null||list2.head==null){
            return null;
        }
        ListNode current1=list1.head;
        ListNode current2=list2.head;
        while(current1!=current2){
            current1=(current1==null?list2.head:current1.next);
            current2=(current2==null?list1.head:current2.next);
        }//找到公共节点。可以模拟两链表相交的情况，会发现让两个节点相同速度分别从表1和表2的头节点出发，
        //当某个节点到达链表尾部的时候，让其回到另外一个链表的头部，这样在它们第一次相遇的时候就会是两个链表的第一个公共节点。
        return current1;
    }

    public static ListNode publicNode(LinkedList list1,LinkedList list2){
        //还有一种方法是计算两个链表的长度差值，然后让较长的节点先走差值步，然后两个节点一起出发，当两个节点相遇的时候，就是
        //两个链表的公共节点。
        if(list1.head==null||list2.head==null){
            return null;
        }
        int len1=list1.getLength();
        int len2=list2.getLength();
        ListNode current1=list1.head;
        ListNode current2=list2.head;
        int diff=0;
        if(len1>len2){
            diff=len1-len2;
            while(diff>0){
                current1=current1.next;
                diff--;
            }
            while(current1!=current2){
                current1=current1.next;
                current2=current2.next;
            }
            return current1;
        }else if(len2>len1){
            diff=len2-len1;
            while(diff>0){
                current2=current2.next;
                diff--;
            }
            while(current1!=current2){
                current1=current1.next;
                current2=current2.next;
            }
            return current1;
        }else{
            while(current1!=current2){
                current1=current1.next;
                current2=current2.next;
            }
            return current1;
        }
    }
}

