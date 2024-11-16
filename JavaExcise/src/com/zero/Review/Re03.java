package com.zero.Review;
//这里是11月15日向ai通义灵码要的一些基础练习题目。
import jdk.jshell.SourceCodeAnalysis;

import java.util.Scanner;

public class Re03 {
    public static void main(String[] args) {
        String str1="hello world";
        String str2="HELLO JAVA";
        review15(str1,str2);
    }
    public static void review01(){
        //复习使用位运算符，但是事实上目前对二进制运算还是太生疏了，无法理解位运算符使用的具体逻辑。

    }
    //下面开始复习流程控制
    public static void review02(int year){
        //这一题，是写一个方法，输入一个年份，判断是否是闰年。
        if(year<0){
            System.out.println("您输入的年份数字有误！");
        }
        else if(year%4==0&&year%100!=0||(year%400==0)){
            System.out.println(year+"年是闰年!");
        }
        else {
            System.out.println(year+"年不是闰年！");
        }
    }
    /*
    勘误：第一：在if的条件判断中，使用逻辑运算符||，而不是单的一个|，而且最好要在||后的算式加上括号，避免出错。
    第二：这个方法是不存在由使用者自己输出年份，只能在主方法内定义一个整型数字然后修改，太麻烦，还是要先学习一下java的输入。
     */
    public static void review03(int score){
        if(score<0||score>100) {
            System.out.println("您输入的分数有误！");
        }
        else{
            //这题的题目是：分数等级转换，输入一个分数，输出对应的等级。
            switch (score / 10) {
                case 10:
                    System.out.println("A");
                case 9:
                    System.out.println("A");
                case 8:
                    System.out.println("B");
                case 7:
                    System.out.println("C");
                case 6:
                    System.out.println("D");
                default:
                    System.out.println("E");
            }
        }//这道题界定的范围，其实用if else比较简单，用switch反而会麻烦一点。
    }
    public static void review04(int num){
        int count=0;
        //这道题目是：数字猜谜游戏，程序随机生成一个数字，玩家来猜谜，猜错之后程序会有所提示，直到玩家猜对位置。
        while(true){
            System.out.println("请输入一个1~100的数字");
            Scanner sc=new Scanner(System.in);
            int guess=sc.nextInt();
            if(guess<0||guess>100){
                System.out.println("您输入的数字有误！");
            }
            else{
                if(guess<num){
                    System.out.println("猜小了！");
                    count++;
                }
                else if(guess>num){
                    System.out.println("猜大了");
                    count++;
                }
                else if(guess==num){
                    System.out.println("猜对了！");
                    System.out.println("您一共猜了"+(count+1)+"次");
                    break;
                }
            }
        }
    }//写这道题的基本逻辑是没有问题的，还需要更熟练才行。

    public static void review05(){
        //这道题是打印乘法表
        for(int i=1;i<=9;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }//这道题也是比较简单的一道题。使用for循环的时候，对循环条件要把握清楚。
    public static void review06(int num){
        int result=1;
        //这道题的题目是：输入一个非负整数，输出它的阶乘
        if(num<0){
            System.out.println("您输入的数字有误！");
        }
        else{
            for(int i=num;i>=1;i--){
                result*=i;
            }
        }
        System.out.println(result);
    }
    public static void review07(int array[]){
        //这道题的题目是：找出整数数组中的最大值和最小值
        int max=array[0];
        int min=array[0];
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }
        System.out.println("数组中的最大值为："+max);
        System.out.println("数组中的最小值为："+min);
    }//这道题的逻辑同样比较简单，代码题要冷静思考再写。
    public static void review08(int num) {
        //这道题的题目是：输入一个数字num，打印出前num个斐波那契数列。
        if (num < 0)
            System.out.println("您输入的数字有误！");
        else if (num == 0)
            System.out.println("0");
        else if (num == 1) {
            System.out.println("0 1");
        }
        else{
            int i=0;
            int pre=0;
            int temp=1;
            int next=0;
            System.out.print("0 1");
            while(i<num){
                next=pre+temp;
                pre=temp;
                temp=next;
                System.out.print(" "+next);
                i++;
            }
        }
    }//这道题用for循环会更加简单。其实运用两个临时变量的想法是一样的，但是运用for循环会更加简单，当然我们要想清楚循环条件。
    /*
    public static void review08(int num){
        int a=0;
        int b=1;
        System.out.print(a+","+b);
        int next;
        for(int i=2;i<num;i++){
            next=a+b;
            a=b;
            b=next;
            System.out.print(","+next);
        }
    }
     */
    public static void review09(String str){
        char ch[]=new char[str.length()];
        int i=0;
        int j=str.length()-1;
        while(i<str.length()){
            ch[i]=str.charAt(j);
            i++;
            j--;
        }
        String str_new=new String(ch);
        System.out.println(str_new);
    }//这个程序的目的是及那个字符串反转。

    //这道题的题目是：判断一个字符串是否是另外一个字符串的子串。
    public static void review10(String str1,String str2){
       int len1=str1.length();
       int len2=str2.length();
       if(len1>len2){
           for(int i=0;i<=len1-len2;i++){
               if(str1.substring(i,i+len2).equals(str2)){
                   System.out.println("str2是str1的子串！");
                   break;
               }
               else{
                   System.out.println("str2不是str1的子串");
               }
           }
       }
       else if(len1<len2){
           for(int i=0;i<len2-len1;i++){
               if(str2.substring(i,i+len2).equals(str1)){
                   System.out.println("str1是str2的子串");
                   break;
               }
               else{
                   System.out.println("str1不是str2的子串");
               }
           }
       }
       else{
           if(str1.compareTo(str2)==0){
               System.out.println("str1与str2内容相同");
           }
           else{
               System.out.println("str1与str2内容不同且不存在子串关系");
           }
       }
    }//写这道题的代码逻辑基本没有错误，但是在使用方法的时候出现了错误！在使用String对象的substring方法时，它的两个参数分别代表的
    //是返回子串的开始位置和结束位置，而不是开始位置和长度！需要记住！
    public static void review11(String str1,String str2,String str3){
        String str_new=new String();
        str_new=str1.replace(str2,str3);
        System.out.println(str_new);
    }
    //这道题主要是为了让我们熟悉字符串对象的replace方法，这个方法有两个参数，一个是旧的子串，一个是新的子串，作用是将
    //字符串中旧的子串替换为新的子串。需要注意的是，如果旧的子串在原字符串中多次出现，那么所有的旧的子串都会被替换为新的子串。
    //还有一个要注意的点是，参数的大小写是有区分的，如果大小写有误，可能会出现找不到旧的子串的错误！
    public static void review12(String str,String str1){
        String str_new[]=str.split(str1);
        for(String a:str_new){
            System.out.println("["+a+"]");
        }
        String []str_new1=str.split(str1,2);
        for(String b:str_new1){
            System.out.println("["+b+"]");
        }
    }//这道题主要是教我们使用字符串对象的split方法。split方法的参数是一个字符串符号，我们以这个符号来将原字符串切割，并且
    //将切割后的结果储存在字符串数组中。solit方法还可以添加一个参数，用于规定切割的次数，切割了几次，字符串数组就会有几个元素。
    public static void review13(String str){
        String str_new=str.trim();
        System.out.println(str_new);
    }//trim方法是去掉字符串的前置空格和后置空格，然后返回修改后的副本。
    public static void review14(String str1,String str2){
        //这道题的题目是进行字符串的大小写转换，String中已经有对应的方法，主要了为了熟悉String的toLowerCase()方法和
        //toUpperCase()方法。
        String str1_new=str1.toUpperCase();
        String str2_new=str2.toLowerCase();
        System.out.println("str1转大写："+str1_new);
        System.out.println("str2转小写："+str2_new);
    }
    public static void review15(String str1,String str2){
        int num=str1.compareTo(str2);
        System.out.println(num);
        //使用compareTo方法我们需要知道它的返回值的机制，compareTo方法是从字符串的第一个字符开始比较，如果字符不同，那么
        //compareTo方法就会返回两个字符的差值，如果比较到最后一个字符都一样，那么compareTo方法就会比较长度并且返回长度的差值
        //如果长度字符都一样，就会返回0。
    }
}

