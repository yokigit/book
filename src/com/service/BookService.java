package com.service;

import com.pojo.Book;
import com.pojo.Page;

import java.util.List;

public interface BookService {
    int addBook(Book book);

    int deleteBook(Integer id);

    int updateBook(Book book);

    Book queryBook(Integer id);

    List<Book> queryBooks();

    Page page(Integer pageNo);

    Page pageByPrice(int pagNo, double min, double max);
}
