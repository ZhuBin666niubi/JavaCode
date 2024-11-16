package com.zero.Chapter04;

public class test04 {
    //来做一下第四章的习题
    public static void main(String[] args) {
        test02();
    }
    public static void test01(){
        //题目：练习使用String类中转换大小写的方法
        String str1="itheima";
        String str2="TIGA";
        String str1_new=str1.toUpperCase();
        String str2_new=str2.toLowerCase();
        System.out.println("str1转大写："+str1_new);
        System.out.println("str2转小写："+str2_new);
    }
    public static void test02(){
        //题目：截取字符串str1和str2中的部分内容，如果截取的两个子串相同就输出相同，不同则输出不同
        String str1="hello world";
        String str2="hello java world";
        String str1_sub=str1.substring(0,5);
        String str2_sub=str2.substring(0,9);
        if(str1_sub.equals(str2_sub)){
            System.out.println("两个子串相同");
        }else{
            System.out.println("两个子串不同");
        }
    }
}
