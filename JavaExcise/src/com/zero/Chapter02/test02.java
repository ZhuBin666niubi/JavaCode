package com.zero.Chapter02;
public class test02 {
    static int age=20;//注意，如果不加上static，那么age就是一个实例变量，在main方法中，我们无法直接访问，除非创建一个实例对象。
    public static void main(String[] args) {
        test03();
    }
    public static void test01(int num1,int num2){
        int num3=num1+num2;
        System.out.println(num3);
    }
    public static void test02(){
        String name="zero";
        System.out.println(name);
        System.out.println(age);
    }
    public static void test03(){
        byte mybyte=10;
        short myshort=20;
        int myint=30;
        long mylong=50000006754564L;
        System.out.println("byte转换为int："+((int)mybyte));
        System.out.println("short转换为int："+((int)myshort));
        System.out.println("long转换为int："+((int)mylong));
    }
}
