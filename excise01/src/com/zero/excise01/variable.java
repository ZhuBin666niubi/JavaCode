package com.zero.excise01;

import java.awt.*;

/**
 * 这串代码是为了学习变量
 */
public class variable {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        Max(a,b);
    }
    public static void  VariableDemo(){
        //变量定义的格式也就是：变量类型+变量名称=变量值
        int a=100;
        System.out.println(a);
    }
    public static void WeChat(){
        double num=9.9;
        System.out.println(num);
        num-=5;
        System.out.println(num);
        num+=6;
        System.out.println(num);
    }
    public static void variableType(){
        //基本数据类型
        int a=10;
        //如果希望输入的浮点型字面量是float类型，那么需要使用f结尾
        double b=10.5;
        char c='A';
        boolean d=true;
        String e="hello";
        byte f=127;
        short g=32767;
        //随便写一个整数类型的字面量，默认属于int类型，如果希望赋值给long类型，需要使用L结尾，否则会被默认为int类型
        long h=99999999999L;
        float i=3.14f;
    }
    public static void Max(int a,int b){
        int max;
        if(a>b)
        {
            max=a;
            System.out.println(a);
        }
        else {
            max=b;
            System.out.println(max);
        }
    }
}
