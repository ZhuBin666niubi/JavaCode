package com.zero.Chapter03;

public class Example08 {
    public static void main(String[] args) {
        CompoundStatements();
    }
    public static void CompoundStatements(){
        //复合语句的使用:java的复合语句是以一个区块为单位的语句，由{开始，到}结束。
        int x=10;
        {
            int y=20;
            System.out.println(y);
            int z=245;
            boolean b;
            {
                b=y>z;
                System.out.println(b);
            }
        }//在这个复合语句中，声明了局部变量y，z，b，我们只能在这个区块中使用它们，而不能在其它区块使用。
        String word="hello java";
        System.out.println(word);
    }
}
