package DynamicProgramming;

public class Fibonacci {

    public static void main(String[] args){

        int x=8;

        int a=0;
        int b=1;
        int sum=0;

        for(int i=0;i<x-2;i++){
            sum=a+b;
            a=b;
            b=sum;
        }

        System.out.println(sum);
    }
}
