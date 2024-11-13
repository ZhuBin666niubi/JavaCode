package com.zero.Chapter02;//一个java程序由很多个类组成，在类中我们用package声明这个类属于哪个包，package也就是包的关键字。
//Java程序的基本组成单元是类，类体中又包含有属性和方法两个部分。每一个程序都必须有一个main方法，这是程序的入口。
//含有main方法的类就叫做主类。
public class Example01 {//文件名
    //文件名必须与类名同名。
    static String S1="你好";
    //通常我们把类的属性叫做类的全局变量（成员变量），将方法中的属性叫做局部变量，区别在于它们的使用范围是不一样的。
    public static void main(String[] args) {
        String S2="Java";
        System.out.println(S1);
        System.out.println(S2);
    }
}
