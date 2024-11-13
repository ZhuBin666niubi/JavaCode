package com.zero.Chapter02;

public class Example05 {
    public static void main(String[] args) {
        VariableDemo();
        ConstantDemo();
        Range();
    }
    /*
    在讲解变量和常量的使用之前，先说一下变量和常量的命名问题。
    变量和常量的命名都需要使用合法的标识符，java语言规定标识符由小写字母、大写字母、数字、下划线、$符号组成，并且不能以数字开头。
    其次，java中，关键字是不能用作标识符的，比如int、if、else、for等。这里稍微提一下，以后学习中再记忆那些比较重要的关键字。
     */
    public static void VariableDemo(){
        //在程序执行过程中，其值可以改变的，叫做变量。不能改变的叫做常量。
        //定义变量就是要告诉编译器，这个变量的数据类型是什么，编译器才知道要分配多少空间给这个变量，也才能知道这个变量能够存储什么样的
        //数据。而再程序运行过程中，分配的内存空间中的东西如果可以改变，说明是一个变量，否则就是一个常量。
        int age=18;
        char char1='r';
        System.out.println(age);
        System.out.println(char1);
    }
    public static void ConstantDemo(){
        //在程序运行过程中一直不会改变的量叫做常量（constant），通常也叫做final变量。一个常量在程序运行过程中只能被赋值一次。
        final int age=18;//这就是常量的声明格式，在变量的声明格式前加上一个final。一个小技巧是：常量通常用大写字母表示。
        //因为常量的特殊性，不会修改，所以一般放在类下面做全局变量，而不用于方法中。
        System.out.println(age);
    }
    int age=18;
    public static void Range(){
        //变量被创造出来之后只是暂存在内存空间中，当程序执行到某一个点的时候，该变量就会被释放掉，也就是说变量是有自己的生命周期的
        //在程序中，一般我们会根据变量的有效范围将变量分为成员变量和局部变量。
        int age=10;
        System.out.println(age);//这里输出的结果是方法中定义的10，方法中，变量名称相同时，成员变量会被隐藏。
        //而局部变量只会在定义的方法中有效，不能用于其它方法。方法被调用时，age就会被分配一个内存空间，当方法使用结束，分配的内存
        //空间会被释放掉。
    }
    int x=45;
    static int y=89;
    //上面的两个变量，都是成员变量，在类中定义的变量，就叫成员变量。x属于实例变量，y属于静态变量，也叫类变量。值得注意的是，
    //类变量的使用范围是可以跨类的，在其它类中我们可以通过使用 类.变量名 的方式来使用类变量。
}
