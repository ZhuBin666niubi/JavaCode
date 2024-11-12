package com.zero.excise02;
//学习方法的格式
public class method {
    public static void main(String[] args) {
        int a=10;
        int b=30;
        int sum=getSum(a,b);
        System.out.println(sum);
    }
    public static int getSum(int a,int b){
        int sum=a+b;
        return sum;
    }
}
