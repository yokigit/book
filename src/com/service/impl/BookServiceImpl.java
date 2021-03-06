package com.service.impl;

import com.dao.BookDao;
import com.dao.impl.BookDaoImpl;
import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;

import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-10 16:03
 */
public class BookServiceImpl implements BookService {
    private final BookDao bookDao = new BookDaoImpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBook(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBook(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    public Page<Book> page(Integer pageNo) {
        Page<Book> page = new Page<Book>();

        int pageTotalCount = Math.toIntExact(bookDao.queryTotalCount());
        page.setPageTotalCount(pageTotalCount);

        int pageSize = page.getPageSize();

        int pageTotal;
        if (pageTotalCount % pageSize == 0) {
            pageTotal = pageTotalCount / pageSize;
        } else {
            pageTotal = pageTotalCount / pageSize + 1;
        }
        page.setPageTotal(pageTotal);

        page.setPageNo(pageNo);

        List<Book> bookList = bookDao.queryItems((pageNo - 1) * pageSize, pageSize);
        page.setItems(bookList);

        return page;
    }

    @Override
    public Page pageByPrice(int pageNo, double min, double max) {
        Page<Book> page = new Page<>();

        int pageTotalCount = Math.toIntExact(bookDao.queryTotalCountByPrice(min, max));
        page.setPageTotalCount(pageTotalCount);

        int pageSize = page.getPageSize();
        if (pageTotalCount % pageSize == 0) {
            page.setPageTotal(pageTotalCount / pageSize);
        } else {
            page.setPageTotal(pageTotalCount / pageSize + 1);
        }

        page.setPageNo(pageNo);

        List<Book> items = bookDao.queryItemsByPrice((pageNo - 1) * pageSize, pageSize, min, max);
        page.setItems(items);

        return page;
    }
}
