package com.dao.impl;

import com.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

abstract public class BaseDao {
    //使用DBUtils操作数据库
    private final QueryRunner queryRunner = new QueryRunner();

    /**
     * update() 用来执行 insert/update/delete语句
     *
     * @param sql  增删改sql语句
     * @param args 操作值
     * @return 返回影响行数，返回-1说明执行失败
     */
    public int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return -1;
    }

    /**
     * 查询返回一个javabean的sql语句
     *
     * @param type 返回的对象类型
     * @param sql  执行的sql语句
     * @param args 操作数
     * @param <T>  返回的类型的类型
     * @return
     */
    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            BeanHandler<T> beanHandler = new BeanHandler<T>(type);
            return queryRunner.query(connection, sql, beanHandler, args);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回多个javabean的sql语句
     *
     * @param type 返回的对象的类型
     * @param sql  执行的sql语句
     * @param args 操作的参数
     * @param <T>  返回的类型的泛型
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        BeanListHandler<T> beanListHandler = new BeanListHandler<T>(type);
        try {
            return queryRunner.query(connection, sql, beanListHandler, args);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

    /**
     * 查询返回一行一列的sql语句
     *
     * @param sql  执行的语句
     * @param args 操作的参数
     * @return
     */
    public Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        ScalarHandler scalarHandler = new ScalarHandler();
        try {
            return queryRunner.query(connection, sql, scalarHandler, args);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            JdbcUtils.close(connection);
        }
        return null;
    }

}
