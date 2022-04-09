package com.test;

import org.junit.Test;

public class ExceptionTest1 {
    @Test
    public void test() {
        try {
            throw new MyException("自定义的异常");
        } catch (MyException e) {
            e.printStackTrace();
        }
    }
}

class MyException extends Exception{
    static final long serialVersionUID = -7034897195766939L;

    public MyException(String msg){
        super(msg);
    }
}

