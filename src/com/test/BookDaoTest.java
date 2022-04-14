package com.test;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import org.junit.Test;

import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-10 15:27
 */
public class BookDaoTest {
    @Test
    public void test() {
        BookDao bookDao = new BookDaoImpl();
//        bookDao.addBook(new Book(null,"1","1",1.0,1,1,"dd"));
//
//        System.out.println(bookDao.queryBookById(22));


//        System.out.println(bookDao.deleteBookById(21));
//        System.out.println(bookDao.updateBook(new Book(23,"1","1",1.0,1,1,"gg")));

//        List<Book> bookList=bookDao.queryBooks();
//        for (Book book:bookList
//             ) {
//            System.out.println(book);
//        }

//        List<Book> bookList=bookDao.queryForItems(4,4);
//        for (Book book: bookList
//             ) {
//            System.out.println(book);
//        }

//        System.out.println(bookDao.queryTotalCount());

        System.out.println(bookDao.queryTotalCountByPrice(10, 50));

        List<Book> bookList = bookDao.queryItemsByPrice(0, 4, 10, 50);
        for (Book book:bookList
             ) {
            System.out.println(book);
        }
    }

}
