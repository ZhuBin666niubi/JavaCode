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
        Node result=Merge(list1,list2);
        while (result != null) {
            System.out.print(result.value + "->");
            result = result.next;
        }
    }

    public static void ReversePrint(LinkedList list) {
        //从尾到头反向打印链表
        if (list.head == null) {
            return;//链表为空，直接返回。
        }
        if (list.head.next == null) {
            System.out.println(list.head.value);
            return;
        }
        //两种想法，第一，用一个新的链表，记录反向顺序的原链表，然后打印新链表；第二个，直接逆转原链表，然后打印。
        Node current = list.head;
        Node newHead = new Node(current.value);
        while (current.next != null) {
            current = current.next;
            Node temp = new Node(current.value);
            temp.next = newHead;
            newHead = temp;
        }//每次把新节点插入新链表的头部，这样就实现了反向顺序。
        current = newHead;
        while (current != null) {
            System.out.print(current.value + "->");
            current = current.next;
        }
        System.out.print("null");//这一部分也可以直接用LinkedList中的print解决。
    }

    public static void ReversePrint2(LinkedList list) {
        //这里是第二种想法：在原链表中实现逆转，再进行打印。
        if (list.head == null) {
            return;
        }
        if (list.head.next == null) {
            System.out.println(list.head.value);
            return;
        }//只有一个节点的话就直接打印。
        Node marknode = list.head;
        Node tempnode = marknode.next;
        while (tempnode != null) {
            marknode.next = tempnode.next;
            tempnode.next = list.head;
            list.head = tempnode;
            tempnode = marknode.next;
        }//实现链表逆转
        list.print();
    }

    public static Node GetKthNode(LinkedList list, int k) {
        //解决这个问题，第一个想法是，直接先遍历一遍链表，记录一下链表的长度，然后根据链表的长度，找到对应的节点。
        if (list.head == null) {
            return null;
        }//链表为空，直接返回。
        int len = 0;
        Node current = list.head;
        while (current != null) {
            current = current.next;
            len++;
        }//遍历链表，获取链表的长度。
        if (k > len) {
            return null;
        } else {
            current = list.head;//将current放回头节点位置，开始遍历寻找倒数第k个节点。
            for (int times = 1; times < len - k + 1; times++) {
                current = current.next;
            }//注意这里的循环条件，times记录的是current的移动次数。
            return current;
        }
    }

    public static Node GetKthNode2(LinkedList list, int k) {
        //第二种想法，我们设置两个节点，一个节点先走到第k个节点，然后两个节点同时出发，当第一个节点到达链表尾部的时候，
        //第二个节点所在的位置就是倒数第k个节点。
        if (list.head == null) {
            return null;
        }
        Node firstnode = list.head;
        Node secondnode = list.head;
        for (int times = 1; times < k; times++) {
            firstnode = firstnode.next;
        }
        while (firstnode.next != null) {
            firstnode = firstnode.next;
            secondnode = secondnode.next;
        }
        return secondnode;
    }

    public static Node CycleEntryNode(LinkedList list) {
        //寻找链表中环的入口节点。
        if (list.head == null || list.head.next == null) {
            return null;
        }//链表为空，或者链表中只有一个节点，直接返回。
        Node fastnode = list.head;
        Node slownode = list.head;
        while (fastnode != null && fastnode.next != null) {
            fastnode = fastnode.next.next;
            slownode = slownode.next;
            if (slownode == fastnode) {
                break;
            }
        }
        if (fastnode == null || fastnode.next == null) {
            return null;
        }//快慢指针没有相遇，说明没有环。
        slownode = list.head;
        while (slownode != fastnode) {
            slownode = slownode.next;
            fastnode = fastnode.next;
        }//快慢指针再次相遇，就是环的入口节点。
        return slownode;
    }

    public static Node Merge(LinkedList list1, LinkedList list2) {
        //合并两个有序链表，链表1和链表2都是有序的。
        if (list1.head == null) {
            return list2.head;
        }
        if (list2.head == null) {
            return list1.head;
        }//如果某个链表为空，那么直接返回剩下那个非空的链表。
        Node temphead = new Node(0);//设置一个虚拟的头节点。
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.value > current2.value) {
                temphead.next = current1;
                current1 = current1.next;
            } else {
                temphead.next = current2;
                current2 = current2.next;
            }
        }//按从小到大的顺序连接链表。
        if (current1 == null) {
            while (current2 != null) {
                temphead.next = current2;
                current2 = current2.next;
            }
        }
        if (current2 == null) {
            while (current1 != null) {
                temphead.next = current1;
                current1 = current1.next;
            }
        }
        return temphead.next;
    }//还是有点问题·，比较大的先插入结果是不对的。
}

