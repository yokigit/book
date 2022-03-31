package com.test;

import com.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void test(){
        for(int i=0;i<20;++i){
            Connection connection= JdbcUtils.getConnection();
            System.out.println(connection);
        }
    }

}
