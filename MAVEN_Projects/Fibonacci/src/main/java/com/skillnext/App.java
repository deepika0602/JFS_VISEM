package com.skillnext;
import java.util.*;
public class App {
    public static void main( String[] args ){
        // 0 1 1 2 3 5 
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n=sc.nextInt();
        int a=0,b=1;
        for(int i=0;i<=n;i++){
            int c=a+b;
            System.out.print(a+" ");
            a=b;
            b=c;
        }
    }
}
