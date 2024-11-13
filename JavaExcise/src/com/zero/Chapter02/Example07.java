package com.zero.Chapter02;

public class Example07 {
    public static void main(String[] args) {
        TypeConversion();
    }
    public static void TypeConversion()
    {
        /*类型转换：类型转换是将一个值从一种类型转化到另外一种类型的过程。比如之前我们在学习char类型的时候，寻找字符在unicde表中
        的位置。其实这就是一种类型转换。
        进行类型转换的时候，如果从低精度转换为高精度，永远不会发生溢出，并且基本能够成功，但是如果从高精度转化为低精度，就可能会发生信息丢失。
        导致失败。
         */
        //数据类型转换有两种方式，隐式转换和显式转换。
        int x=10;
        float y=x;
        System.out.println(y);
        //结果为10.0，说明转换成功。其实这就是隐式转换。从低精度到高精度的转换，系统会自动执行，我们无需操作。这种类型的转换也就
        //叫做隐式转换。
        byte mybyte=10;
        int myint=150;
        float myfloat=452.12f;
        char mychar='a';
        double mydouble=45.44645;
        System.out.println("byte和float运算的结果为："+(mybyte+myfloat));
        System.out.println("char和double运算的结果为："+(mychar+mydouble));
        System.out.println("byte和int运算的结果为："+(mybyte+myint));
        System.out.println("char和int运算的结果为："+(mychar+myint));
        System.out.println("int和double运算的结果为："+(myint+mydouble));
        //其实隐式转换可以看成是不同精度的操作数运算时，系统自动将低精度的操作数转换为高精度的过程。
        float f=10.5f;
        int a=(int)f;//如果不加上(int)，会提示报错。
        byte b=(byte)129;
        System.out.println(b);
        /*
        1. 类型转换
        在这段代码中，129 是一个 int 类型的字面量。byte 类型的范围是从 -128 到 127，而 129 超出了 byte 类型的范围。
        因此，需要进行类型转换。
        2. 溢出处理
        当将一个超出 byte 范围的 int 值强制转换为 byte 时，Java 会截断高阶位，只保留低 8 位。具体来说：
        129 的二进制表示为 00000000 00000000 00000000 10000001（32位 int）
        截取低 8 位后，得到 10000001
        3. 二进制到十进制的转换
        10000001 是一个带符号的 byte，最高位（第 7 位）是 1，表示这是一个负数。根据补码的规则，我们可以将其转换为十进制：
        反码：将 10000001 的每一位取反，得到 01111110
        补码：将反码加 1，得到 01111111
        01111111 的十进制值是 127，因此 10000001 的十进制值是 -127。
         */
    }
}
