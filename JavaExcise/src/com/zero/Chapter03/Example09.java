package com.zero.Chapter03;

public class Example09 {
    public static void main(String[] args) {
        Control();
    }
    public static void IFStatements(){
        //条件语句根据不同的条件执行不同的语句。下面我们先来看看简单的if条件语句。
        int x=100;
        if(x>99)
            System.out.println(x);
        System.out.println("--------");
        //简单的if-else语句。
        int y=89;
        if(x>y){
            System.out.println("x变量的值大于y变量的值");
        }
        else {
            System.out.println("x变量的值小于y变量的值");
        }
        System.out.println("--------");//这里我们再写一个例子。
        int chinese=90;
        int math=53;
        if(chinese>60){
            System.out.println("语文成绩及格了");
        }
        else{
            System.out.println("语文成绩没有及格");
        }
        if(math>60){
            System.out.println("数学成绩及格了");
        }
        else{
            System.out.println("数学成绩没有及格");
        }
        System.out.println("--------");//我们尝试用三元表达式来完成上面代码的功能。
        boolean b=chinese>60?true:false;
        if(b){
            System.out.println("语文及格了");
        }
        else{
            System.out.println("语文不及格");
        }
        b=math>60?true:false;
        if(b){
            System.out.println("数学及格了");
        }
        else{
            System.out.println("数学不及格");
        }
        //学习完一般的if-else格式后，接下来我们来学习if-elseif多分支语句。
        int alcohol=190;
        if(alcohol==0){
            System.out.println("没有喝酒，可以放行");
        }
        else if(alcohol>0&&alcohol<=60){
            System.out.println("少量饮酒，警告一次");
        }
        else if(alcohol>60&&alcohol<=130){
            System.out.println("已经醉酒，予以抓捕");
        }
        else{
            System.out.println("直接击毙");
        }
        //从上面这么多例子可以看出，if语句是选择执行条件为真的区块，其它区块的代码都不执行。
    }
    public static void SwitchStatements(){
        //讲解完if，现在我们来看看switch语句。
        int day=8;
        switch(day){
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            case 6:
                System.out.println("星期六");
                break;
            case 7:
                System.out.println("星期天");
                break;
            default:
                System.out.println("您输入的数字有误！");
                break;
            /*对比if语句，switch提供的多选一代码格式更加的简洁明了。
            注意：switch语句中的表达式必须是整型、字符型或者是字符串类型，常量值1~n也必须是整型、字符型或者是字符串类型，否则报错。
            同一个switch语句中，常量值不能相同！
            了解完这些，我们再简单写一个小例子
             */
        }
        System.out.println("--------");
        String word="尚硅谷";
        switch(word){
            case "黑马程序员":
                System.out.println("月薪过万就来黑马程序员");
                break;
            case "汉码未来":
                System.out.println("山东本土，没有分校");
                break;
            case "尚硅谷":
                System.out.println("北京师资，力量强大");
                break;
            default:
                System.out.println("小牌厂家，不好说");
        }
    }
    public static void Circulate(){
        /*讲解完if和switch两个选择语句，现在我们来看看循环语句。
        循环语句就是再满足一定条件的情况下，反复执行某一个操作。在java中一共有三个常用的循环语句，分别是：while语句，
        for语句，do...while语句。下面开始学习while语句。
         */
        //while语句也叫做条件判断语句，它的循环方式是利用一个条件控制是否反复执行下面代码块的语句。
        int x=0;
        int sum=1;
        while(x<=10){
            sum+=sum;
            x++;
        }//这就是一个完整的while循环了，判断一个while循环的输出结果，首先看循环条件，以此判断循环次数，再看输出的操作数的变化规律。
        System.out.println(sum);
        System.out.println("--------");
        int times=0;
        int count=1;
        while(times<=10){
            count+=times;
            times++;
        }
        System.out.println(count);
        System.out.println("--------");
        //看完while语句，我们再看看do-while语句。
        int i=0;
        int num=0;
        do{
            i++;
            num+=i;
        }while(i<=10);
        System.out.println(num);
        /*do...while语句和while语句很相似，但是do...while语句至少会执行一次循环。
        do...while语句会先执行语句块，再判断条件是否符合，所以在写代码或者做题时要注意这个点。
         */
        System.out.println("--------");
        //下面来看看for语句
        int a=0;
        for(int j=1;j<=99;j+=2){
            a+=j;
        }
        System.out.println(a);
        System.out.println("--------");
        //下面来看for语句的一种简化形式，foreach
        int arr[]={7,10,1};
        System.out.println("一维数组中的元素分别为:");
        for(int n:arr){
            System.out.println(n);
        }//for语句中，foreach语句的格式是：for(数据类型 变量名:数组名){}遍历数组比较简单。
    }
    public static void Control(){
        //学完了三个循环语句，现在我们来看看循环语句的控制语句。
        for(int i=0;i<=100;i++){
            System.out.println(i);
            if(i==6)
                break;
        }//break语句的作用是跳出当前循环体。在循环嵌套的环境下，break只能跳出当前循环体，而不能结束嵌套的所有循环。
        System.out.println("--------");
        for(int i=0;i<=10;i++){
            for(int j=0;j<100;j++){
                System.out.println(j);
                if(j==6)
                    break;
            }
            System.out.println("-------");
        }//break跳出了内层循环，didn't print 7-99 次的j
        System.out.println("--------");//现在来看看continue
        for(int i=1;i<=20;i++){
            if(i%2==0){
                continue;
            }
            System.out.println(i);
        }
    }
}
