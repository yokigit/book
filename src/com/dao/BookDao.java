package com.dao;

import com.pojo.Book;

import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-10 14:34
 */
public interface BookDao {
    int addBook(Book book);

    int deleteBookById(Integer id);

    int updateBook(Book book);

    Book queryBookById(Integer id);

    List<Book> queryBooks();

    List<Book> queryItems(Integer begin,Integer size);

    Long queryTotalCount();
}
