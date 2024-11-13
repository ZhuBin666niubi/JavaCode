package com.zero.Chapter02;

public class Example03 {
    public static void main(String[] args) {
        EscapeCharacter();
    }
    public static void EscapeCharacter()//转义字符
    {
        //转义字符是一种特殊的字符变量，它不是字母，而是由反斜杠（\）开头，后面跟一个或者多个字符。
        //转义字符具有特殊的含义和用法，不同于字符原本的意义所以叫做转义字符。
        char c1='\'';//\'可以将单引号正确输出
        char c2='\\';//\\可以将反斜杠正确输出
        System.out.println(c1);
        System.out.println(c2);
        //还有很多其它的转义字符，我们可以在后续的代码中慢慢记忆，比如/n表示换行符，等等。
    }
}
