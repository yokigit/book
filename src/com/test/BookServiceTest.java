package com.test;

import com.service.BookService;
import com.service.impl.BookServiceImpl;
import org.junit.Test;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-10 16:07
 */
public class BookServiceTest {
    @Test
    public void test() {

        BookService bookService = new BookServiceImpl();
//        System.out.println(bookService.addBook(new Book(null, "2", "2", 2.0, 2, 2, "ee")));

//        System.out.println(bookService.updateBook(new Book(23, "2", "2", 2.0, 2, 2, "gg")));

//        System.out.println(bookService.deleteBook(23));

//        System.out.println(bookService.queryBook(23));

//        List<Book> bookList=bookService.queryBooks();
//
//        for (Book book:bookList
//             ) {
//            System.out.println(book);
//        }

//        Page page = bookService.page(2);
//        System.out.println(page);

    }
}
