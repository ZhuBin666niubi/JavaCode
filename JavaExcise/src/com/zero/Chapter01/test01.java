package com.zero.Chapter01;
/*
第一章的内容是初识Java，以及下载配置java环境，了解java编程工具的使用，这里我们使用的是idea。
 */
public class test01 {
    public static void main(String[] args) {
        int a=10;
        int b=5;
        test2(a,b);
    }
    public static void test1()
    {
        //这道题是为了掌握java语言的基础格式，并且了解怎么输出对应内容
        System.out.println("《Java从入门到精通》");
        System.out.println("是我学习Java语言的最佳书籍");
    }
    public static void test2(int a,int b)
    {
        //输出两个整数的加减乘除的结果
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
    }
}
