package com.zero.Review;
//这里是书籍《java从入门到精通》的第四章到第五章的练习题。
public class Re02 {
    public static void main(String[] args) {
        int x=7;
        review03();
    }
    public static void review01(){
        String str1="hello world";
        String str2="hello java";
        String s1=str1.substring(0,4);
        String s2=str2.substring(0,4);
        int b=s1.compareToIgnoreCase(s2);
        if(b==0){
            System.out.println("两个子串相同");
        }
        else {
            System.out.println("两个子串不相同");
        }
    }//这个题目是定义两个字符串，分别截取两个字符串的一部分，也就是获取两个子串，然后对比两个子串且不分大小写，如果相同则输出
    //子串相同，不同则输出子串不同。
    public static void review02(int x){
        for(int i=0;i<x;i++){
            for(int j=0;j<x-1-i;j++){
                System.out.print(" ");
            }
            for(int k=0;k<2*(i+1)-1;k++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<x-1;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(" ");
            }
            for(int k=0;k<x*2-1-2*(i+1);k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void review03() {
        double x = 1.0;
        int i = 1;
        double sum = 0.0;
        while (i <= 20) {
            x *= i;
            sum += 1 / x;
            i++;
        }
        System.out.println(sum);
    }
}
