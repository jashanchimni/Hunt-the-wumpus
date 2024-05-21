/** 
import java.util.Scanner;
import java.io.*;
import java.lang.System;
import java.lang.String;

public class Trivia {

    public static void main(String Args[]) throws IO Exception{
        String username;
        String password;
        String ans1, ans2, ans3, ans4, ans5, ans6, ans7, ans8, ans9, ans10, ans11, ans12, ans13, ans14, ans15, ans16, ans17, ans18, ans19, ans20, ans21, ans22, ans23, ans24, ans25;
        int i = 0;
        int x = 0;
        do{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Scanner s = new Scanner(System.in);
            System.out.println("1. WANT COINS");
            System.out.println("2. DO NOT WANT COINS");
            System.out.println("3. EXIT");
            System.out.println("Enter your choice: ");
            x = Integer.parseInt(br.readLine());

            switch(x){
                case 1: 
                    System.out.println("WANT COINS");
                    System.out.println("\nUsername: ");
                    username = br.readLine();

                    System.out.println("Password: ");
                    password = br.readLine();
                    break;

                case 2:
                    System.out.println("ADMIN");
                    break;

                case 3:
                    System.out.println("EXIT!");
                    System.exit(0);

                default:
                    System.out.println("INVALID CHOICE");
            }

            System.out.println("What console did Microsoft create? ");
            Sysout{}
        }
    }
}
**/
