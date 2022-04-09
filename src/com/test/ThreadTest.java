package com.test;

class MyThread extends Thread {
    private static int tickets=100;

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        while (tickets > 0) {
            show();
        }
    }

    //public synchronized void show(){   //此时,锁为 MyThread 类的多个线程对象, 不是同一把锁

    public static synchronized void show(){  //此时，锁为该类，类只加载一次
        if (tickets > 0) {
            System.out.println(currentThread().getName()+"：售出票号"+(101-tickets--));
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread("window1");
        MyThread thread2 = new MyThread("window2");
        MyThread thread3 = new MyThread("window3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
