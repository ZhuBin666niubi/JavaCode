package com.zero.Chapter04;

import org.w3c.dom.ls.LSOutput;

import java.util.Date;

public class Example11 {
    public static void main(String[] args) {
        String str="hello java";
        StringBuilder(str);
    }
    //在Example10中我们学习了字符串的基本概念以及一些字符串的常用方法，接下来我们来学习如何对字符串进行操作。
    public static void GetSub(){
        //String提供了substring()方法，该方法可以获取字符串中一段子串。
        String str="hello java";
        String str1=str.substring(0);
        System.out.println(str1);
        String str2=str.substring(3,9);
    }
    public static void RemoveSpace(){
        //String提供了trim()方法返回字符串的副本，并且会忽略前导空格和后导空格。中间的空格不会被去掉
        String s="   Hello Java     ";
        String s1=s.trim();
        System.out.println(s);
        System.out.println(s1);
    }
    public static void Replace() {
        //replace()方法可以实现将指定的字符或字符串替换成新的字符或者字符串
        String oldstr = "hello world";
        String newstr = oldstr.replace("world", "java");
        System.out.println(newstr);
        String s1="hello hello hello world";
        String s2=s1.replace("hello","hi");
        System.out.println(s2);
    }//注意：replace()方法不会改变原来的字符串，而是返回一个新的字符串。并且，如果被替换的字符在原字符串中多次出现，那么所有出现
    //的字符都会被替换。
    public static void Judge(){
        //String提供了startsWith()和endsWith()方法，判断字符串是否以指定的字符或字符串开头或结尾。它们的返回值都是布尔类型。
        String s="hello world";
        boolean b1=s.startsWith("h");
        System.out.println("字符串s是以h开头的吗："+b1);
        boolean b2=s.endsWith("d");
        System.out.println("字符串s是以d结尾的吗："+b2);
        boolean b3=s.endsWith("java");
        System.out.println("字符串s是以java结尾的吗："+b3);
    }
    public static void Compare(){
        //对字符串对象进行比较，我们不能简单的使用比较运算符“==”来判断两个字符串是否相等。因为==运算符比较的是两个对象的引用，
        //也就是两个对象的地址是否相同。我们要知道，即便两个字符串的内容相同，它们的内存地址也是不相同的，使用比较运算符就会返回false
        //因此我们使用String中的equals()方法和equalsIgnoreCase()方法来比较两个字符串。
        String s1="itcast";
        String s2="ITCast";
        boolean b1=s1.equals(s2);
        System.out.println("s1和s2的内容是相同的："+b1);
        //equals方法，在两个字符串具有相同的字符和长度时，会返回true，否则返回false。但是equalsIgnoreCase()方法，会忽略大小写。
        boolean b2=s1.equalsIgnoreCase(s2);
        System.out.println("s1和s2的内容是相同的，忽略大小写："+b2);
    }
    public static void CompareTo(){
        //compareTo()方法是按照字典顺序来比较两个字符串，比较的是字符的值是否相同，是基于Unicode的值来比较的。
        //compareTo()方法比较字符串的具体逻辑是：先逐次比较两个字符串的字符，直到遇到不同的字符，随后就会返回不同字符的Unicode差值
        //如果对应字符都相同，就比较长度，返回长度差值。
        String s1="itheima";
        String s2="itheimu";
        int result=s1.compareTo(s2);
        System.out.println(result);//输出的应该是一个负数，值应该是a到u的差值。
    }
    public static void CaseConversion(){
        //String提供了toLowerCase()和toUpperCase()方法，可以将字符串中的字符转换为小写和大写。
        String s1="itheima";
        String S2="ITHEIMA";
        String Str1=s1.toUpperCase();
        String str2=S2.toLowerCase();
        System.out.println("s1中字母转大写："+Str1);
        System.out.println("s2中字母转小写"+str2);
    }
    public static void Split(){
        //String提供了split()方法，可以将字符串按照指定的字符或字符串进行分割，返回一个字符串数组。
        String s="I'm American Captain,I'm a hero";
        String [] FirstSpilt=s.split(",");
        String [] SecondSpilt=s.split("'|,",3);
        for(String a:FirstSpilt){
            System.out.println(a);
        }
        for(String b:SecondSpilt){
            System.out.println(b);
        }
    }
    public static void Format(){
        //学习完前面的操作，现在我们来学习怎么格式化字符串
        //String类的静态Format方法用于创建格式化的字符串。
        Date date=new Date();
        String s=String.format("当前时间是%tF",date);
    }
    public static void StringBuilder(String str){
        StringBuilder sb=new StringBuilder(str);
        for(int i=1;i<=10;i++){
            sb.append(i);
        }
        System.out.println(sb);
    }
}
