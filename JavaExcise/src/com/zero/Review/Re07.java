package com.zero.Review;

public class Re07 {
    public static void main(String[] args) {
        String src="hello world";
        String dest="ok";
        Boolean result=IsContaining(src,dest);
        System.out.println(result);
    }

    public static void BubbleSort(int arr[]){
        //冒泡排序：逻辑是，循环数组，两两比较，每次把一个最大的值放在数组的尾部，直到排序完成。
        int len=arr.length;
        if(len<=1){
            return;
        }//数组中的元素值小于两个就不用排序了。
        for(int i=1;i<len;i++){
            for(int j=0;j<len-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }//注意这里的循环条件
            }//每次循环都把最大的值放在数组的尾部。
        }
    }

    public static void SwitchSort(int arr[]){
        //直接选择排序二点逻辑是，每次循环找出一个最大的值，放在数组的尾部。
        int len=arr.length;
        if(len<=1){
            return;
        }
        for(int times=1;times<len;times++){
            int index=0;
            for(int current=1;current<=len-times;current++){
                if(arr[index]<arr[current]){
                    index=current;
                }
            }//寻找最大元素
            int temp=arr[index];
            arr[index]=arr[len-times];
            arr[len-times]=temp;
        }
    }

    public static Boolean IsContain(String src,String dest){
        //判断字符串是否包含另一个字符串
        int src_len=src.length();
        int dest_len=dest.length();
        if(src_len<dest_len){
            return false;
        }
        for(int index=0;index<=src_len-dest_len;index++){
            if(src.charAt(index)!=dest.charAt(0)){
                continue;
            }else{
                for(int index_dest=1;index_dest<dest_len;index_dest++){
                    if(src.charAt(index+index_dest)!=dest.charAt(index_dest)){
                        break;
                    }
                    if(index_dest==dest_len-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static Boolean IsContaining(String src,String dest){
        //判断是否包含
        int src_len=src.length();
        int dest_len=dest.length();
        if(src_len<dest_len){
            return false;
        }
        for(int index=0;index<=src_len-dest_len;index++){
            if(src.charAt(index)!=dest.charAt(0)){
                continue;
            }else{
                for(int index_dest=1;index_dest<dest_len;index_dest++){
                    if(src.charAt(index+index_dest)!=dest.charAt(index_dest)){
                        break;
                    }
                    if(index_dest==dest_len-1){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
