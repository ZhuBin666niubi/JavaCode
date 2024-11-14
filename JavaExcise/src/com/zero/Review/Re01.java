package com.zero.Review;

public class Re01 {
    static int age=10;
    public static void main(String[] args) {
        test08();
    }
    public static void test01(){
        System.out.println("《Java从入门到精通》");
        System.out.println("是我学习Java的最佳书籍");
    }
    public static void test02(int a,int b){
        System.out.println("两数相加为："+(a+b));
        System.out.println("两数相减为:"+(a-b));
        System.out.println("两数相乘为:"+(a*b));
        System.out.println("两数相除为："+(a/(double)b));
    }
    public static void test03(int a,int b){
        System.out.println("两数相加为："+a+b);
    }//还需要考虑数字的类型
    public static void test04(){
        String name="itheima";
        System.out.println("我的名字是："+name);
        System.out.println("我的年龄是:"+age);
    }//区别就在于，成员变量的适用范围是全局，static修饰后甚至可以在类外引用。
    public static void test05(byte mybyte,short myshort,int myint,long mylong){
        System.out.println("byte型整型组转化为int型："+(int)mybyte);
        System.out.println("short型整型组转化为int型："+(int)myshort);
        System.out.println("long型整型组转化为int型："+(int)mylong);
    }
    public static void test06(int x){
        if(x<=0){
            System.out.println("您输入的数字有误！");
        }
        else if(x%2==0){
            System.out.println("x是偶数");
        }
        else {
            System.out.println("x是奇数");
        }
    }
    public static void test07(int x){
        for(int i=0;i<x;i++){
            for(int j=0;j<x-1-i;j++){
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
            for(int k=0;k<x*2-1-2*(i+1);k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void test08(){
        int i=1;
        int x=1;
        double sum=0;
        while(i<=20){
            x*=i;
            sum+=(double)1/x;
            i++;
        }
        System.out.println(sum);
    }
}
