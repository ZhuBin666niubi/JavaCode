package com.zero.Review;
//11月17号第一次代码题目测试，测试结果不大行，对代码的逻辑要了解清楚再写，写代码的时候要注意规范命名。
public class Test01 {
    public static void main(String[] args) {
        String src = "hello world";
        String dest = "ll";
        boolean result = IsSub(src,dest);
        System.out.println(result);
    }

    public static boolean test01(String src, String dest) {
        //接收两个字符串src和dest，判断dest是否是src的子串。
        int strlen = src.length();
        int destlen = dest.length();
        boolean result = false;
        if (src.length() < dest.length()) {
            result = false;
        } else {
            for (int i = 0; i < strlen; i++) {
                int index = 0;//先找到第一个字符，再判断后面的字符是否一致
                if (src.charAt(i) == dest.charAt(index)) {//找到第一个字符，再开始判断dest后面的是否符合。
                    for (int j = 1; j < destlen; j++) {
                        if (src.charAt(i + j) != dest.charAt(j)) {
                            result = false;//找到有不一样的，就结束内层循环，在外层循环中找到另外的第一个相同的字符。
                            break;//如果内层循环没有结束，说明找到了，返回true。
                        }
                        else if(j==destlen-1){
                            result=true;
                            return result;
                        }//执行之后，
                    }

                }
            }
        }
        return result;
    }
    public static void test02(int arr[]){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                int temp=max;
                max=arr[i];
                arr[i]=temp;
            }
        }
    }
    public static boolean IsSub(String src,String dest) {
        //要写一个方法，判断dest是否是src的子串，那么返回值肯定是boolean类型的。
        //其次我们开始思考问题怎么解决，无非两种情况，dest是src的子串，dest不是src的子串，那么怎么判断呢?
        //dest是src的子串的话，那么dest一定和src某个区段的字符串子串相同，要判断两个字符串是否相同，我们就要对比它们的
        //字符是否一致，于是我们先找到一个src中和dest第一个字符相同的字符位置，然后比对剩下的字符是否可以配对。
        //这其中当然有各种临界条件。
        if (src.length() == 0 || dest.length() == 0)
            return false;//如果两个字符串中有一个是空字符串，那么直接返回false
        if (dest.length() > src.length())
            return false;//如果dest的字符串长度大于src的字符串长度。那dest肯定不会是src的子串，返回false
        //现在我们开始在src中找到一个和dest第一个字符相同的字符。
        boolean result = false;//声明一个返回结果，并且初始化为false
        int src_len = src.length();
        int dest_len = dest.length();
        for (int index = 0; index < src_len; index++) {
            char ch = src.charAt(index);
            if (ch == dest.charAt(0)) {
                if (src_len - index < dest_len) {
                    break;//如果从index到最后一个元素的长度比dest的长度小，那么这次的配对肯定失败。
                } else {
                    for (int index_dest = 1; index_dest < dest_len; index_dest++) {
                        if (src.charAt(index + index_dest) != dest.charAt(index_dest)) {
                            break;
                        }
                        if (index_dest == dest_len - 1) {//如果没有推出循环，说明之前的配对已经完成，而如果index_dest等于
                            //dest的字符串长度-1的话，就说明已经配对到最后一个并且没有错误，说明dest是src的子串。
                            result = true;
                            return result;
                        }//只有这种情况，dest才是src的子串，那么其它我们就都返回false
                    }
                }
            }
        }
        return result;
    }
    public static void BubbleSort(int[] arr){
        if(arr.length<=1){
            System.out.println("数组长度为1，不需要排序");
        }
        else{
            for(int times=1;times<arr.length;times++){
                for(int index=0;index<arr.length-times;index++){
                    if(arr[index]>arr[index+1]){
                        int temp=arr[index];
                        arr[index]=arr[index+1];
                        arr[index+1]=temp;
                    }
                }
            }
        }
    }
}
