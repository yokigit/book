package com.test;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-07 18:56
 */

class Bank {
    private static Bank instance;
    private Bank() {

    }

    public static Bank getInstance() {
        //效率稍低的
//        synchronized (Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//            }
//            return instance;
//        }

        //效率更高的
        if (instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class SingleLetonTest{
    public static void main(String[] args) {
        Bank bank1=Bank.getInstance();
        Bank bank2=Bank.getInstance();

        System.out.println(bank1==bank2);
    }
}
