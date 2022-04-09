package com.test;

import static java.lang.Thread.sleep;

/**
 * @program: spring5_demo1
 * @author: yoki1
 * @create: 2022-04-08 23:41
 */
class A{
    public synchronized void function1(B b){  //锁：a
        System.out.println(Thread.currentThread().getName()+"进入A的function1方法");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        b.function2();
    }

    public synchronized void function2(){      //锁：a
        System.out.println(Thread.currentThread().getName()+"进入A的function2方法");
    }
}
class B{
    public synchronized void function1(A a){   //锁：b
        System.out.println(Thread.currentThread().getName()+"进入B的function1方法");
        try {
            sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.function2();
    }

    public synchronized void function2(){      //锁：b
        System.out.println(Thread.currentThread().getName()+"进入B的function2方法");
    }
}

public class DeadLock extends Thread{
    A a=new A();
    B b=new B();

    @Override
    public void run() {
        b.function1(a);
    }

    public void init(){
        a.function1(b);
    }

    public static void main(String[] args) {
        DeadLock deadLock=new DeadLock();
        deadLock.setName("副线程");
        currentThread().setName("主线程");

        deadLock.start();
        deadLock.init();

    }
}
