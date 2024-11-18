package com.zero.Review;

import java.util.Arrays;

public class Re05 {
    public static void main(String[] args) {
        review04();
    }
    public static void review01(){
        int arr[]=new int[]{2,3,13,42,72,55};
        int max=arr[0];int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.println("数组中的最大值为:"+max);
        System.out.println("数组中的最小值为:"+min);
    }
    public static void review02(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                System.out.println("不是回文");
                break;
            }
        }
        System.out.println("是回文字符串");
        //这是一种方法，还可以先反转再比较。
        StringBuilder sb=new StringBuilder(str).reverse();
        String str_new=sb.toString();
        if(str_new.equals(str)){
            System.out.println("是回文字符串！");
        }
        else{
            System.out.println("不是回文字符串!");
        }
    }
    public static void review03(){
        int arr[]=new int []{23,31,47,56,42,55,79,84};
        int sum=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                sum+=arr[i];
            }
        }
        System.out.println("奇数之和为："+sum);
    }
    public static void review04() {
        int arr[] = new int[]{23, 31, 47, 56, 42, 55, 79, 84};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }//这就是冒泡排序
    }
    public static void review05(){
        int arr[]=new int[]{23,31,47,56,42,55,79,84};
        for(int i=0;i<arr.length;i++){
            int index=0;
            for(int j=1;j<arr.length-i;j++){
                if(arr[index]>arr[j]){
                    index=j;
                }
            }
            int temp=arr[index];
            arr[index]=arr[i];
            arr[i]=temp;
        }
    }
}
