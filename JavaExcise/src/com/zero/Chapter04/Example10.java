package com.zero.Chapter04;
/*
之前第二章学习了java语言基础，包括语言的格式和基本数据类型。第三章我们学习了流程控制，包括if、switch、循环等。接下来我们来学习字符串。
 */
public class Example10 {
    public static void main(String[] args) {
        GetInformation();
    }
    public static void Foundation(){
        //char类型只能表示单个字符，不能表示由多个字符串连接而成的字符串。在java语言中，字符串会被当作对象来处理，我们可以
        //通过java.lang包下的String类来创建字符串对象。
        String myString="hello world";//声明字符串对象必须要初始化才能使用，不然会报错。
        System.out.println(myString);
        //我们可以像创建其它对象一样来创建字符串对象。而创建对象要使用类的构造方法。String类的常用构造方法如下：
        char a[]={'g','o','o','d'};
        String s=new String(a);//前面两个语句等价于String s=new String("good");
        System.out.println(s);
        //第二种方法
        char b[]={'h','e','l','l','o'};
        String s1=new String(b,1,3);//这种方法提取了字符数组的一部分来创建字符串对象。
        System.out.println(s1);
        //第三种方法，使用String的静态方法valueOf()
        char c[]={'h','e','l','l','o'};
        String s2=String.valueOf(c);
        System.out.println(s2);
    }
    public static void Connect(){
        //对于已经声明的字符串对象，我们可以对它进行连接操作。可以将字符串与字符串相连接也可以和其它的数据类型进行连接。
        String s1="hello";
        String s2="world";
        String s3=s1+s2;
        System.out.println(s3);
        System.out.println("---------");
        int time=4;
        float practice=3;
        System.out.println("我今天花费了"+time+"小时来看书"+practice+"小时来练习");
        //这其中，"我今天花费了"可以叫做字符串常量。
        //只要+运算符的其中一个操作元是字符串，编译器就会把所有操作元都转换为字符串模式，以免出现意想不到的结果。
    }
    public static void GetInformation(){
        //之前提到过，字符串是对象，对象有方法，而字符串也有一些方法。我们可以通过这种方法来获取字符串的一些相关信息。
        String s1="itheima";
        int length=s1.length();
        System.out.println("s1的长度是"+length);
        //通过String对象的length方法可以获取字符串的长度。
        String s2="itheima have a good itcast";
        int index=s2.indexOf("it");
        System.out.println("it的位置是"+index);
        index=s2.lastIndexOf("it");
        System.out.println(index);
        //indexOf()方法可以获取字符串中某个字符第一次出现的位置，而lastIndexOf()方法可以获取字符串中某个字符最后一次出现的位置。
        //注意，如果lastIndexOf()方法中给的参数是空字符，那么它的返回值将会与length方法的返回值相同，这也可以用来获取字符串长度。
        index=s2.lastIndexOf("");
        System.out.println(index);
        int size=s2.length();
        System.out.println(size);
        //String类还提供了一些其它的方法，比如charAt()方法，用于获取字符串中某个位置的字符。
        char ch=s2.charAt(4);
        System.out.println("s2中索引为四的字符是："+ch);
    }
}
