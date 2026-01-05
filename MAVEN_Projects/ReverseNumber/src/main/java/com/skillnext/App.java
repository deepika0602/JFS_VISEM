package com.skillnext;

import java.util.Scanner;
//Reverse Number in java

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number n: ");
        int n = sc.nextInt();
        int rev = 0;
        while (n > 0) {
            int rem = n % 10;
            n /= 10;
            rev = rev * 10 + rem;
        }
        System.out.println("Reverse of the given number " + n + " is: " + rev);
    }
}
