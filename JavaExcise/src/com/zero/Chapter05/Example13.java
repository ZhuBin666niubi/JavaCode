package com.zero.Chapter05;

import java.util.Arrays;

public class Example13 {
    //上波我们学习了一维数组和二维数组的创建和使用，为了更好的运用数组来解决问题，现在我们来学习数组的基本操作。
    public static void main(String[] args) {
        SortingAlgorithms03();
    }
    public static void IterateArray(){
        //遍历数组
        int arr[]={1,2,3,4,5,6,7,8,9,10};
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }//这就是一维数组的遍历，我们可以通过简单的for循环来达到目的。
        String str[][]=new String[][]{{"a","b"},{"c","d"},{"e","f"}};
        for(int i=0;i<str.length;i++){
            for(int j=0;j<str[i].length;j++){
                System.out.println(str[i][j]);
            }
        }
        System.out.println("--------");
        int array[][]={{4,8,3},{9,2}};
        int i=0;//这里的i是用作计时器，记录处理的数据的行数。
        for(int x[]:array){
            i++;
            int j=0;//j记录列数
            for(int y:x){
                j++;
                if(i==array.length&&j==array[array.length-1].length){
                    System.out.print(y);
                }
                else{
                    System.out.print(y+"、");
                }
            }
        }/*这个遍历二维数组的方式，其中需要注意的几个点是：
        第一，通过查询之后，我们了解到，foreach编译之后就是一个for循环的形式，但是，需要注意的是，我们在上面代码中定义的i和j，
        并不是for循环的循环变量，而是用来记录循环信息的，以便我们输出需要的信息。
        第二、在教材中，if判断的条件是：i==array.length&&j==x.length，刚开始看我们会觉得疑惑，因为很显然，根据数据来看，我们的
        x的长度是有变化的，第一个array元素里面的x的length是3，第二个是2，为什么j会用x.length来判定呢？
        是因为有一个前置条件i==array.length，所以综合起来，j==x.length的时候，循环就已经遍历到了数组的最后一个元素了。当然，
        复杂一点写，按照正常逻辑，用array[array.length-1].length来判断也是可以的。
        */
    }
    public static void Padding(){
        /*学习完遍历数组，现在我们来看怎么填充替换数组元素：
        数组的填充，我们通过Array类中的静态方法Arrays.fill(array,value)方法来完成，其中array是数组，value是填充的值。
        作用是将指定的value值分配给数组中的每一个元素。
         */
        int arr[]=new int[10];
        Arrays.fill(arr,5);
        for(int i:arr){
            System.out.println(i);
        }
        //这是fill方法的第一种形式，除此之外，我们还可以界定一个范围，将指定的value值赋值给范围内的每一个元素。
        System.out.println("--------");
        int arr2[]=new int[]{1,2,3,4,5,6};
        Arrays.fill(arr2,0,5,6);
        for(int i:arr2){
            System.out.println(i);
        }
    }
    public static void Sort(){
        /*
        学习完数组的遍历，数组的填充，现在我们来看一下数组的排序。
        数组的排序，我们通过Arrays.sort(array)方法来完成，其中array是我们要进行排序的数组。排序的形式是升序排序，也就是从小到大。
         */
        int arr[]=new int[]{2,5,78,343,23};
        Arrays.sort(arr);
        for(int i:arr){
            System.out.println(i);
        }//这里我们是对整型数组进行了排序处理，在java中，String类型数组的排序算法是根据字典编排顺序排序的，所以数字在字母前面
        //大写字母在小写字母前面。
    }
    public static void Copy(){
        //现在来看看数组的复制。和前面数组的排序和填充一样，Array类也提供了赋值数组的方法。
        int array[]=new int[]{23,43,15,69,90};
        int arr_new[]=Arrays.copyOf(array,5);
        for(int i:arr_new){
            System.out.println(i);
        }//Array的CopyOf方法，有两个参数，一个是需要复制的数组名，还有一个是新数组的长度。这个方法会返回一个数组，所以我们需要声明
        //一个新的数组来接收返回值。除了CopyOf方法，Array类还有一个CopyOfRange方法，这个方法在原复制的基础上来提供了复制范围
        //参数。
        System.out.println("--------");
        int arr2[]=new int []{12,45,76,41,99};
        int arr3[]=Arrays.copyOfRange(arr2,2,8);
        for(int i:arr3){
            System.out.println(i);
        }//需要注意的是，新数组的长度是根据参数来计算的，而不是与原数组的长度相同。
    }
    public static void Search(){
        //现在我们来学习一下数组查询。同样的，Array类提供了查询数组的方法binarySearch。
        int arr[]=new int[]{4,25,10};
        int index=Arrays.binarySearch(arr,0,1,8);
        System.out.println(index);
        //输出的结果是-2。为什么呢？
        /*
        首先我们要了解，Array类提供的binarySearch方法，是采用二分搜索法来搜索指定数组，以获得指定的对象。它有四个参数，
        分别是：要进行搜索的数组array，搜索的起始范围start，搜索的结束范围end，要搜索的对象value。如果找到了值，就返回其在数组
        内的索引，如果没有找到，就会返回一个负数，这个负数是-（插入点）-1。插入点则是找到的第一个比value大的元素的索引，如果找不到，
        插入点就是数组的长度。
        需要注意的是：如果没有对数组进行排序，就无法使用binarySearch方法。如果数组中有重复元素，我们无法确定找到的是哪一个。
         */
    }
    public static void SortingAlgorithms01(){
        //现在我们来学习数组的排序算法,包括冒泡排序，直接选择排序和反转排序。
        int arr[]=new int[]{23,45,67,89,12};
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i:arr){
            System.out.println(i);
        }//这种比较方法效率是比较低的，比一般的冒泡排序比较的次数要多一点
        System.out.println("--------");
        int arr2[]=new int[]{23,45,67,89,12};
        for(int i=0;i<arr2.length-1;i++){
            for(int j=0;j<arr2.length-i-1;j++){
                if(arr2[j]>arr2[j+1]){
                    int temp1=arr2[j];
                    arr2[j]=arr2[j+1];
                    arr2[j+1]=temp1;
                }
            }
        }//两两比较，从第一次比较开始，一定会把一个最大值往数组的最后放，所以内层循环次数也就减少一次，所以循环条件也就是
        //j<arr.length-1-i。而外层循环，因为两两比较到最后，肯定只剩下一个元素，无需比较，所以外层循环的次数就为数组的长度-1。
    }
    public static void SortingAlgorithms02(){
        //学习完冒泡排序，现在我们来看看直接选择排序。
        int arr[]=new int[]{23,45,67,89,12};
        for(int i=1;i<arr.length;i++){
            int index=0;
            for(int j=1;j<=arr.length-i;j++){
                if(arr[j]>arr[index]){
                    index=j;
                }
            }//选出最大的元素，然后和数组的最后一个元素进行交换。
            int temp=arr[arr.length-1-i];
            arr[arr.length-1-i]=arr[index];
            arr[index]=temp;
            //这里把最大的元素放在数组最后，循环结束，之后又一次循环开始，index又被赋0，然后与之后的数组值进行比较，原本的最后一个
            //元素已经放好了，对比次数就变成了arr.length-1-i。
        }//综合来看，直接选择排序的对比次数小于冒泡排序。
    }
    public static void SortingAlgorithms03(){
        //学习完前面两种排序方法，现在我们来看看反转排序。反转排序就是把数组从头到尾进行反转。比较简单
        int arr[]=new int[]{23,45,67,89,12};
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[i];
            arr[i]=arr[arr.length-1-i];
            arr[arr.length-1-i]=temp;
        }//用while循环也行。
        for(int i:arr){
            System.out.println(i);
        }
    }
}
