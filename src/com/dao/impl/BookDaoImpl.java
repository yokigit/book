package com.dao.impl;

import com.dao.BookDao;
import com.pojo.Book;

import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-10 14:39
 */
public class BookDaoImpl extends BaseDao implements BookDao {

    @Override
    public int addBook(Book book) {
        String sql = "insert into table_book values(?,?,?,?,?,?,?)";
        return update(sql, book.getId(), book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from table_book where id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update table_book set id=?,name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?";

        return update(sql, book.getId(), book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(), book.getImg_path(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from table_book where id=?";

        return queryForOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from table_book";
        return queryForList(Book.class, sql);
    }

    @Override
    public List<Book> queryItems(Integer begin, Integer size) {
        String sql = "select * from table_book limit ?,?";
        return queryForList(Book.class, sql, begin, size);
    }

    @Override
    public Long queryTotalCount() {
        String sql = "select count(*) from table_book";
        return (Long) queryForSingleValue(sql);
    }
}
