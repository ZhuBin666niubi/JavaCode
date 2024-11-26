package com.zero.Test;

public class Review {
    public static void main(String[] args) {
       LinkedList list=new LinkedList();
       list.addNode(1);
       list.addNode(1);
       list.addNode(2);
       list.addNode(3);
       list.addNode(3);
       list.PrintList();
       deleteDuplicates(list);
       list.PrintList();
    }

    public static void DeleteKToLastNode(LinkedList list,int k){
        //思路是：先设置一个虚拟头节点，然后声明一个节点current等于虚拟头节点，让current出发找到第k-1个节点，如果循环中
        //current为空，说明链表长度小于k，（注意，当链表为空的时候，current为空，所以不用对链表为空的情况特殊判断。）
        //然后再设置一个节点，preNode，让preNode等于虚拟头节点，然后两个节点一起出发，当current.next为空，也即是
        //当current到达链表的尾部时，preNode到达倒数第k个节点。
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
        }
        if(current==null){
            return;
        }//如果current为空，说明链表长度小于k，直接返回。当链表为空，k值一定大于链表长度，所以不用特殊处理。
        ListNode preNode=DummyHead;
        while(current.next!=null){
            preNode=preNode.next;
            current=current.next;
        }
        preNode.next=preNode.next.next;//删除倒数第k个节点。
        list.head=DummyHead.next;
    }

    public static void ReversePortNode(LinkedList list,int k,int m){
        //思路：先设立一个虚拟头节点，然后声明一个节点current，用current遍历链表，找到第k个节点，遍历过程中，如果
        //current为空，说明链表长度小于k，直接返回。接着开始反转指定范围内的节点，设置节点markNode为current，
        //设置节点markHead为current，设置节点nextNode为current.next，每次把nextNode放在markHead的前面，
        //就能实现反转操作。反转过程中，如果nextNode为空，并且记录反转次数的变量count还小于m-k，说明链表长度小于m，
        //直接返回。
        if(k<=0||m<=0||k>=m){
            return;
        }
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode current=DummyHead;
        int index=0;
        while(current!=null&&index<k){
            current=current.next;
            index++;
        }//遍历找到第k个节点
        if(current==null){
            return;
        }//链表长度小于k，直接返回。
        ListNode markNode=current;
        ListNode markHead=current;
        ListNode nextNode=current.next;
        int count=0;
        while(nextNode!=null&&count<m-k){
            markNode.next=nextNode.next;
            nextNode.next=markHead;
            markHead=nextNode;
            nextNode=markNode.next;
            count++;
        }//实现反转操作
        if(count!=m-k){
            return;
        }//count不等于m-k的话，就说明反转的过程中，nextNode为空了，也就是链表的长度小于m，直接返回。
        ListNode preNode=DummyHead;
        index=0;
        while(index<k-1){
            preNode=preNode.next;
            index++;
        }//遍历找到第k个节点的前置节点，然后进行连接操作。
        preNode.next=markHead;
        list.head=DummyHead.next;
    }

    public static void ReverseList(LinkedList list){
        //反转链表，思路：先设置一个虚拟头节点，然后执行链表反转操作。
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode markHead=DummyHead;
        ListNode nextNode=DummyHead.next;
        while(nextNode!=null){
            DummyHead.next=nextNode.next;
            nextNode.next=markHead;
            markHead=nextNode;
            nextNode=DummyHead.next;
        }//实现反转操作
        if(list.head==null){
            return;
        }//其实不用判断链表是否为空，因为链表为空时，DummyHead.next为空，所以不会进入循环。但是，后续的代码中我们会用到
        //listhead.next，所以这里的判断是有必要的。
        list.head.next=null;
        list.head=markHead;//这一句好像不加也行。
    }

    public static ListNode MergeList(LinkedList list1,LinkedList list2){
        //合并两个排序的链表。思路是：声明一个虚拟头节点，然后设置两个节点current1和current2节点，分别从两个链表的
        //头节点出发，然后开始比较，每次让较小的节点和前置节点连接。
        ListNode DummyHead=new ListNode(0);
        ListNode current1=list1.head;
        ListNode current2=list2.head;
        ListNode preNode=DummyHead;
        while(current1!=null&&current2!=null){
            if(current1.value<= current2.value){
                preNode.next=current1;
                current1=current1.next;
            }
            else{
                preNode.next=current2;
                current2=current2.next;
            }
            preNode=preNode.next;
        }//比较两个节点，连接较小节点。
        if(current1==null){
            while(current2!=null){
                preNode.next=current2;
                current2=current2.next;
                preNode=preNode.next;
            }
        }
        if(current2==null){
            while(current1!=null){
                preNode.next=current1;
                current1=current1.next;
                preNode=preNode.next;
            }
        }
        return DummyHead.next;
    }

    public static boolean HasCycle(LinkedList list){
        //判断链表中是否有环：先声明一个虚拟头节点，然后设置两个节点，fastNode和slowNode，fastNode每次走两步
        //slowNode每次走一步。如果fastNode和slowNode相遇，说明链表中有环。
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode fastNode=DummyHead;
        ListNode slowNode=DummyHead;
        while(fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode){
                return true;
            }//fastNode和slowNode相遇，则说明链表中是有环的。
        }
        return false;//fastNode为空或者fastNode.next为空，说明链表中没有环。
    }

    public static ListNode getCycleNode(LinkedList list){
        //返回链表中的环节点。思路：用双指针法先找到，然后返回。
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode fastNode=DummyHead;
        ListNode slowNode=DummyHead;
        while(fastNode!=null&&fastNode.next!=null){
            fastNode=fastNode.next.next;
            slowNode=slowNode.next;
            if(fastNode==slowNode){
                break;
            }
        }
        if(fastNode==null||fastNode.next==null){
            return null;
        }//如果fastNode为空或者fastNode.next为空，说明链表中没有环，直接返回null。
        fastNode=DummyHead;
        while(fastNode!=slowNode){
            fastNode=fastNode.next;
            slowNode=slowNode.next;
        }
        return slowNode;
    }

    public static ListNode getKToLastNode(LinkedList list,int k){
        //获取链表中倒数第k个节点。
        ListNode DummyNode=new ListNode(0);
        DummyNode.next=list.head;
        ListNode current=DummyNode;
        int index=0;
        while(current!=null&&index<k){
            current=current.next;
            index++;
        }
        if(current==null){
            return null;
        }
        ListNode KthNode=DummyNode;
        while(current.next!=null){
            KthNode=KthNode.next;
            current=current.next;
        }//当current为空，说明遍历到了链表的末尾，此时KthNode就是倒数第k个节点的前置节点。
        return KthNode.next;
    }

    public static ListNode getPublicNode(LinkedList list1,LinkedList list2){
        //获取两个链表的公共节点。思路：声明两个虚拟头节点，然后设置两个节点，分别从两个链表的虚拟头节点出发，
        //当某一个节点到达链表尾部的时候，让其为另外一个链表的虚拟头节点，然后继续遍历，直到两个节点相等。
        //如果两个节点最后为空，则说明没有公共节点,返回的也就是null，不然就返回公共节点。
        ListNode DummyHead1=new ListNode(0);
        DummyHead1.next=list1.head;
        ListNode DummyHead2=new ListNode(0);
        DummyHead2.next=list2.head;
        ListNode current1=DummyHead1;
        ListNode current2=DummyHead2;
        while(current1!=current2){
            current1=(current1==null?DummyHead2:current1.next);
            current2=(current2==null?DummyHead1:current2.next);
        }
        return current1;//这个函数中虚拟节点的作用是防止链表为空，当链表为空，因为虚拟头节点的存在，函数依然能够成功运行而不
        //用再设立临界条件。
    }

    public static ListNode sumList(LinkedList list1,LinkedList list2){
        //遍历两个俩表依次相加即可，重点是临界条件的设立。
        ListNode resultHead=new ListNode(0);
        ReverseList(list1);
        ReverseList(list2);//将两个链表反转，以便进行计算。
        ListNode DummyHead1=new ListNode(0);
        DummyHead1.next=list1.head;
        ListNode DummyHead2=new ListNode(0);
        DummyHead2.next=list2.head;
        int result=0;//用于记录每一个位的和。
        boolean carry=false;//用于记录进位。
        ListNode current1=DummyHead1.next;
        ListNode current2=DummyHead2.next;
        while(current1!=null&&current2!=null){
            if(current1.value<0||current1.value>9){
                System.out.println("链表中存在非法节点");
                return null;
            }
            if(current2.value<0||current2.value>9){
                System.out.println("链表中存在非法节点");
                return null;
            }
            result=current1.value+current2.value+(carry?1:0);
            if(result>=10){
                carry=true;
                result-=10;
            }else{
                carry=false;
            }//判断是否进位。
            ListNode resultNode=new ListNode(result);
            resultNode.next=resultHead.next;
            resultHead.next=resultNode;//将结果节点插入到结果链表的头部。
            current1=current1.next;
            current2=current2.next;
        }//当某一个链表遍历完成时，将另一个链表的剩余部分插入到结果链表的头部。
        if(current1==null){
            while(current2!=null){
                if(current2.value<0||current2.value>9){
                    System.out.println("链表中存在非法节点");
                    return null;
                }
                result=current2.value+(carry?1:0);
                if(result>=10){
                    carry=true;
                    result-=10;
                }else{
                    carry=false;
                }
                ListNode resultNode=new ListNode(result);
                resultNode.next=resultHead.next;
                resultHead.next=resultNode;
                current2=current2.next;
            }
        }
        if(current2==null){
            while(current1!=null){
                if(current1.value<0||current1.value>9){
                    System.out.println("链表中存在非法节点");
                    return null;
                }
                result=current1.value+(carry?1:0);
                if(result>=10){
                    carry=true;
                    result-=10;
                }else{
                    carry=false;
                }
                ListNode resultNode=new ListNode(result);
                resultNode.next=resultHead.next;
                resultHead.next=resultNode;
                current1=current1.next;
            }
        }
        if(carry){
            ListNode resultNode=new ListNode(1);
            resultNode.next=resultHead.next;
            resultHead.next=resultNode;
        }
        return resultHead.next;
    }

    public static void sortInList(LinkedList list){
        //将链表按照升序排序。
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode current=DummyHead.next;
        while(current!=null){
            ListNode tempNode=current.next;//记录current之后的节点，进行值的比较。
            while(tempNode!=null){
                if(tempNode.value< current.value){
                    int temp=current.value;
                    current.value=tempNode.value;
                    tempNode.value=temp;
                }//把最小的值放在前面。
                tempNode=tempNode.next;
            }
            current=current.next;
        }
        list.head=DummyHead.next;//链表为空时，因为虚拟头节点的存在，就可以得到正常处理。
    }

    public static boolean isPail(LinkedList list){
        //判断一个链表是否是回文结构。
        if(list.head==null||list.head.next==null){
            return true;
        }
        ListNode DummyHead1=new ListNode(0);
        DummyHead1.next=list.head;
        ListNode current1=DummyHead1;
        int length=0;
        while(current1!=null){
            current1=current1.next;
            length++;
        }//获取链表的长度。这里的长度是加上了虚拟头节点，之后获取中间的节点时比较方便。
        current1=DummyHead1;
        for(int index=0;index<length/2;index++){
            current1=current1.next;
        }//走到中心节点。
        ListNode startNode=current1.next;//下半部分节点的开始节点。
        ListNode nextNode=startNode.next;
        ListNode tempHead=startNode;
        while(nextNode!=null){
            startNode.next=nextNode.next;
            nextNode.next=tempHead;
            tempHead=nextNode;
            nextNode=startNode.next;
        }//实现下半部分节点的反转，反转之后就可以开始比较了。
        ListNode DummyHead2=new ListNode(0);
        DummyHead2.next=tempHead;//将反转后的链表挂到虚拟头节点上。接着让两个链表进行比较。
        ListNode current2=DummyHead2;
        current1=DummyHead1;
        while(current2!=null){
            if(current1.value!=current2.value){
                return false;
            }
            current1=current1.next;
            current2=current2.next;
        }
        return true;
    }

    public static void oddEvenList(LinkedList list){
        //将一个链表分为奇数节点和偶数节点进行排列。
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode current=DummyHead;
        int length=0;
        while(current!=null){
            current=current.next;
            length++;
        }//获取链表的长度。
        int arr[]=new int[length];
        current=DummyHead;
        for(int index=0;index<length;index++){
            arr[index]=current.value;
            current=current.next;
        }//将链表的值保存到数组中。
        current=DummyHead.next;
        int count=0;
        while(count<length/2){
            current.value=arr[count*2+1];
            current=current.next;
            count++;
        }
        count=1;
        while(current!=null){
            current.value=arr[count*2];
            current=current.next;
            count++;
        }
        list.head=DummyHead.next;
    }

    public static void deleteDuplicates(LinkedList list){
        //删除链表中重复的节点。
        ListNode DummyHead=new ListNode(0);
        DummyHead.next=list.head;
        ListNode current=DummyHead.next;
        while(current!=null&&current.next!=null){
            if(current.next.value==current.value){
                current.next=current.next.next;
            }else{
                current=current.next;
            }
        }
        list.head=DummyHead.next;
    }


}
