package com.zero.Chapter05;

public class test06 {
    public static void main(String[] args) {
        int arr[]={5,4,3,2,1};
        BubbleSort(arr);
        for(int i:arr){
            System.out.println(i);
        }
    }
    public static void SwitchSort(int arr[]){
        int arrlen=arr.length;
        if(arrlen<=1){
            return;//如果数组只有一个元素，就不用排序，直接返回即可。
        }else{
            //数组元素大于一个元素，则进行排序。
            for(int i=1;i<arrlen;i++){//这是是外层循环，每一次循环我们把一个最大值放在数组的最后，所以当数组只剩下一个元素我们
                //就不用继续排序，因此循环的次数往往比数组元素少一个。所以让i从1开始。
                int index=0;//记录每一次循环中我们要找的最大值的索引。
                for(int j=1;j<=arrlen-i;j++){
                    if(arr[index]<arr[j]){
                        index=j;
                    }
                }//循环完一次，index就记录了当前最大的元素的索引。
                int temp=arr[arrlen-i];
                arr[arrlen-i]=arr[index];
                arr[index]=temp;
                //将最后一个元素的值与最大值进行交换。
            }//每一次外层循环的执行，就表示我们将一个最大值放在了数组最后，最后外层循环结束，排序就完成了。
        }
    }
    public static void BubbleSort(int arr[]){
        //冒泡排序
        int arrlen=arr.length;
        if(arrlen<=1){
            return;
        }else{
            //冒泡排序，每一次外层循环将一个最大值放在数组最后一位，内层循环通过两两比较的方式将最大值后挪。
            for(int i=1;i<arrlen;i++){
                for(int j=0;j<arrlen-i;j++){//这里j的循环条件是arrlen-1-i，因为后续我们以j和j+1比较，如果j循环到
                    //arrlen-i，则j+1就越界了。
                    if(arr[j]>arr[j+1]){
                        int temp=arr[j+1];
                        arr[j+1]=arr[j];
                        arr[j]=temp;
                    }//这样就实现了将最大值后移的操作。
                }
            }
        }
    }
}
