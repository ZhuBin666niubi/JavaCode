package com.zero.Chapter03;

public class test03 {
    public static void main(String[] args) {
        int x=7;
        test02(7);
    }
    public static void test01(int x) {
        if(x<=0){
            System.out.println("您输入的数字有误！");
        }
        else if(x%2==0){
            System.out.println("偶数");
        }
        else{
            System.out.println("奇数");
        }
    }
    public static void test02(int x) {
        for(int i=0;i<x;i++){
            for(int j=0;j<x-i-1;j++){
                System.out.print(" ");
            }
            for(int k=0;k<i*2+1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<x-1;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(" ");
            }
            for(int k=0;k<(x*2-1)-2*(i+1);k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }//研究规律，然后再转化为代码逻辑，要静心慢慢看。
    public static void test03(){
        double x=1;
        int i=1;
        double sum=0;
        while(i<=20){
            x=x*i;
            sum+=1/x;
            i++;
        }
        System.out.println(sum);
    }
}
