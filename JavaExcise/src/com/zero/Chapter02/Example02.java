package com.zero.Chapter02;

public class Example02 {
    public static void main(String[] args) {
        CharType();
    }
    public static void IntegerType(){
        //下面是java中四种整数类型--没有小数部分的数值，可以为正，也可以是负
        byte mybyte=124;//占8个比特位，最大值为127
        short myshort=32564;//占16个比特位，最大值为32767
        int myint=438483853;//占32个比特位，最大值为2147483647
        //long占64个比特位，最大值为9223372036854775807
        long mylong=23423423423L;//注意，在定义一个long类型的变量时，值后面要加上L，否则会报错。
        long result=mybyte+myshort+myint+mylong;
        System.out.println("结果为:"+result);
    }
    public static void FloatType(){
        //下面是Java中两种浮点数类型--有小数部分的数字
        //float占32个比特位，double占64个比特位
        float myfloat=3.14f;//在声明一个float类型变量的时候，如果不加上f，那么它默认为double类型。
        double mydouble=3.1415926;
        System.out.println("float类型："+myfloat);
        System.out.println("double类型："+mydouble);
    }
    public static void CharType(){
        //char类型，只能有一个字符，并且以单引号括起来的，并且只能是单字节字符。char占用16个比特位。
        char mychar='A';
        System.out.println("char类型："+mychar);
        //java语言是可以把字符作为整数对待的，这涉及到了unicode编码的知识。
        char word='d',word2='@';
        int p=23067,p2=45343;
        System.out.println("d在unicode的表格中的顺序位置是："+(int)word);
        System.out.println("@在unicode的表格中的顺序位置是："+(int)word2);
        System.out.println("unicode表格中的第23067位是:"+(char)p);
        System.out.println("unicode表格中的第45343位是:"+(char)p2);
        //利用这种简单的技巧，我们可以通过代码来知道字母的unicode编码。
    }
}
