package com.test;

import org.junit.Test;

import java.util.Scanner;

public class ExceptionTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num2 = scanner.nextInt();
//        main(args);
        //OutOfMemoryError
//        Integer[] arr=new Integer[1024*1024*1024];
    }

    @Test
    public void test() {
        String str = "<h1><div><a href=''>nihao</a></div></h1>";
        String abc = "abc";
        System.out.println("\"aab\" = " + "aab");
    
        //FileNotFoundException
//        File file=new File("hello.txt");
//        FileInputStream fileInputStream=new FileInputStream(file);
//        int data=fileInputStream.read();
//        while(data!=-1){
//            System.out.println((char)data);
//            data=fileInputStream.read();
//        }
//        fileInputStream.close();

        //ClassNotFoundException


        //NullPointerException
//        String str=null;
//        str.charAt(0);

        //StringIndexOutOfBoundsException
//        String str1="abc";
//        str1.charAt(3);
//
//        //ArrayIndexOutOfBoundsException
//        int[] arr=new int[3];
//        arr[3]=1;
//
//        //ClassCastException
//        Object o=new String("abc");
//        Integer integer=(Integer)o;
//
//        //NumberFormatException
//        String str2="abc123";
//        int num=Integer.parseInt(str2);
//
//        //InputMismatchException

//
        //ArithmeticException
//        double num3=10/0;

    }
}
