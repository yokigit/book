
package com.test;

class MyRunnable implements Runnable {

    private int ticket = 100;

    @Override
    public void run() {
        while (ticket>0) {
            show();
        }
    }

    public synchronized void show() {  //此时，锁为this,即当前实现Runnable的对象
        if (ticket > 0) {
            System.out.println(Thread.currentThread().getName() + "：售出票号" + (101 - ticket--));
        }
    }
}

public class RunnableTest {

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();

        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        thread1.setName("window1");
        thread2.setName("window2");
        thread3.setName("window3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
