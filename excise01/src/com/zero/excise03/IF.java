package com.zero.excise03;

public class IF {
    public static void main(String[] args) {

    }
    public static void testIf(int a, int b){
        if(a>b){
            System.out.println("a>b");
        }else if(a==b){
            System.out.println("a==b");
        }else{
            System.out.println("a<b");
        }
    }
    public static void testWhile(){
        int i=0;
        while(i<10){
            System.out.println("i="+i);
            i++;
        }
    }
    //判断1-100之间，有多少个是素数
    public static void testFor(){
        int count=0;
        for(int i=1;i<=100;i++){
            boolean flag=true;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        System.out.println("1-100之间有"+count+"个素数");
    }

}
