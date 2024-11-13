package com.zero.Chapter02;

public class Example06 {
    public static void main(String[] args) {
        Ternary();
    }
    public static void Assignment(){//运算符
        //运算符是一些特殊的符号，主要用于数学函数、一些类型的赋值语句和逻辑比较方面。java中提供了相当多的运算符供我们使用。
        int a;
        a=100;//=,也就是赋值运算符，作用是将=的右边的值赋给左边的变量。
        int b=10;
        int c=a+b;
        System.out.println(c);
        a=b=c=b+5;//一个语句中有多个赋值运算符，那么这些赋值运算符都是从左到右依次执行的。
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);//java中我们是可以将赋值运算符连在一起使用的，但实际工作中不建议这样做。
    }
    public static void Arithmetic(){
        //java中的算数运算符主要包括加+、减-、乘*、除/、取余%,它们都是二元运算符。
        float number1=45.56f;
        int number2=152;
        System.out.println("和为："+(number1+number2));
        System.out.println("差为:"+(number1-number2));
        System.out.println("积为:"+(number1*number2));
        System.out.println("商为:"+(number1/number2));//进行除法运算时，0不能作为除数，否则会报错。
    }
    public static void Self(){
        //自增自减运算符是单目运算符，可以放在操作数前也可以放在操作数后面。操作元必须是一个整型或者浮点型变量。
        int num=10;
        int num2;
        num2=++num;
        System.out.println(num2);
        num=10;
        num2=num++;
        System.out.println(num2);
        //通过前面代码的运行结果我们可以看出，自增/自减运算符放在前面，会先改变操作元的值再让操作元进行运算，而放在后面，会先
        //让操作元参与运算再进行对应的值的改变。
    }
    public static void Comparison(){
        //比较运算符属于二元运算符，用于程序中信息的比较，比较运算符的结果是boolean类型的。
        int num1=100;
        float num2=100.3f;
        System.out.println("num1大于num2:"+(num1>num2));
        System.out.println("num1小于num2:"+(num1<num2));
        System.out.println("num1等于num2:"+(num1==num2));
        System.out.println("num1大于等于num2:"+(num1>=num2));
        System.out.println("num1小于等于num2:"+(num1<=num2));
        System.out.println("num1不等于num2:"+(num1!=num2));
    }
    public static void Logical(){
        //逻辑运算符也属于二元运算符，它主要用于组合返回值是boolean类型的表达式为逻辑表达式，用来表达一些复杂的条件判断。
        int num1=10;
        int num2=13;
        boolean result1=num1>num2;//定义bool类型的变量接收表达式num1>num2的结果
        boolean result2=num1<num2;
        System.out.println("result1与result2的逻辑与运算结果为:"+(result1&&result2));
        //逻辑与运算符，&&，如果两个表达式都为true，那么返回true，否则返回false。
        System.out.println("result1与result2的逻辑或运算结果为:"+(result1||result2));
        //逻辑或运算符，||，如果两个表达式有一个为true，那么返回true，否则返回false。
        System.out.println("result1与result2的逻辑非运算结果为:"+(!result1));
        //逻辑非运算符，!，如果表达式为true，那么返回false，否则返回true。
    }
    public static void Bit(){
        //位运算符是二元运算符，主要用于对整数进行位运算。
        //整数在电脑中会用二进制进行表示，一个整数的二进制也就是整数的原码。位运算符就是对应着整数的二进制进行运算。
        int num1=8;
        int num2=7;
        System.out.println("num1与num2的按位与运算结果为:"+(num1&num2));
        //按位与运算符，&，如果两个二进制位都为1，那么返回1，否则返回0。
        System.out.println("num1与num2的按位或运算结果为:"+(num1|num2));
        //按位或运算符，|，如果两个二进制位有一个为1，那么返回1，否则返回0。
        System.out.println("num1与num2的按位异或运算结果为:"+(num1^num2));
        //按位异或运算符，^，如果两个二进制位不同，那么返回1，否则返回0。
        //除此之外，还存在一个运算符叫做按位取反，~，它将二进制位取反，也就是将1变成0，将0变成1。
        System.out.println("~num1的结果为:"+~num1);
        System.out.println("--------");
        //除去这些操作之外，我们还可以对数据按二进制位进行移位操作。java中存在三种移位符，分别是左移、右移、无符号右移。
        int num3=8;
        int result3;
        System.out.println("num3左移两位的结果为:"+(num3<<2));
        System.out.println("num3右移两位的结果为:"+(num3>>2));
        System.out.println("num3无符号右移两位的结果为:"+(num3>>>2));
    }
    public static void Ternary(){
        //三元运算符，也叫条件运算符，它的使用格式为：表达式?值1:值2。
        //运算规则是：如果表达式的结果为true，那么返回值1，否则返回值2。
        int num1=7;
        int num2=9;
        int result=num1<num2?num2:num1;
        System.out.println(result);
        //其实这个运算符也就等价于if else语句。
        if(num1<num2)
        {
            System.out.println(num2);
        }else
            System.out.println(num1);
    }


    //上面我们已经学习了很多常用的运算符，但是需要了解的是，运算符之间是存在优先级的，运算符间的优先级是固定的。
    //通常来说，运算符的优先级由高到低为：
    /*
    1、增量和减量运算
    2、算术运算符
    3、比较运算符
    4、逻辑运算符
    5、赋值运算符
    如果优先级相同，计算顺序是从左到右的。
    然后还有一点，在代码编写的时候，我们尽量使用括号来明确运算的优先级，这样能够提高代码的可读性。
     */
}
