package com.zero.Review;

public class Re04 {
    public static void main(String[] args) {
        String str="hello world hello java";
        review03(str);
    }
    public static String review01(String str){
        //这道题的题目是编写一个字符串，返回其反转后的字符串。
        char strarry[]=new char[str.length()];
        for(int i=0;i<str.length();i++){
            strarry[i]=str.charAt(str.length()-1-i);
        }
        String str_new=new String(strarry);
        return str_new;
    }//这道题很简单，但是要注意字符串的长度是比字符串的最大索引要多一的。
    public static void review02(String str){
        //这道题的核心逻辑和上一道题基本一致。题目的内容是判断一个字符串是否是回文字符串：也即是其反过来和原来的是不是一样。
        char array[]=new char[str.length()];
        for(int i=0;i<str.length();i++){
            array[i]=str.charAt(str.length()-1-i);
        }
        String str_new=new String(array);
        boolean b=str.equals(str_new);
        if(b){
            System.out.println("该字符串是回文字符串");
        }
        else{
            System.out.println("该字符串不是回文字符串");
        }
    }
    public static void review03(String str){
        //这道题的题目是接受一个英文句子，将句子中的每一个单词反转之后输出。
        String array[]=str.split(" ");
        for(String a:array){
            char x[]=new char[a.length()];
            for(int i=0;i<a.length();i++){
                x[i]=a.charAt(a.length()-1-i);
            }
            String c_new=new String(x);
            System.out.print(c_new+" ");
        }
    }//问题重点在于怎么把句子中的每一个单词分割出来，而String类中刚好提供了split方法来分割字符串。
    public static void review04(String str){
        //这道题的题目是将接收的字符串的重复字母去掉，只保留一个
        /*
        char ch[]=new char[str.length()];
        char pre;
        char temp;
        int i=0;
        while(i<str.length()){
        }
         */
        //这道题没有做出来哈，想要使用双层遍历来解决，发现找不到一个好的遍历条件。现在我们来看一种解题方法
        StringBuilder sb=new StringBuilder();
        boolean b[]=new boolean[128];
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(!b[c]){
                b[c]=true;
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
        //这道题的思路还是很值得学习的，我们在处理有关字符的问题的时候，可以想到字符是有值的，此时定义一个布尔类型的数组，可以有效
        //记录字符是否存在的相关情况。
    }
}
