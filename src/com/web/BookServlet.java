package com.web;

import com.pojo.Book;
import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-10 16:17
 */
public class BookServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
        book.setImg_path("");
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        if (bookService.addBook(book) != -1) {
            System.out.println("添加图书成功");
            req.getRequestDispatcher("/manager/bookServlet?action=page&pageNo=" + pageNo).forward(req, resp);
        } else {
            System.out.println("数据库操作失败");
            req.getRequestDispatcher("/manager/bookServlet?action=page&pageNo=" + pageNo).forward(req, resp);
        }
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        if (bookService.deleteBook(id) == -1) {
            System.out.println("数据库操作失败");
        } else {
            req.getRequestDispatcher("/manager/bookServlet?action=page&pageNo=" + pageNo).forward(req, resp);
        }
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        Book book = WebUtils.copyParamToBean(new Book(), req.getParameterMap());
        //获取修改的记录所在页码
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        book.setImg_path("");
        if (bookService.updateBook(book) == -1) {
            System.out.println("数据库操作失败");
            req.getRequestDispatcher("/manager/bookServlet?action=page&pageNo=" + pageNo).forward(req, resp);
        } else {
            req.getRequestDispatcher("/manager/bookServlet?action=page&pageNo=" + pageNo).forward(req, resp);
        }
    }

    protected void query(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("books", bookService.queryBooks());

        req.getRequestDispatcher("/pages/manager/book_manager.jsp?action=query").forward(req, resp);
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        if (bookService.queryBook(id) != null) {
            req.setAttribute("book", bookService.queryBook(id));
        } else {
            System.out.println("数据库操作失败，获取图书失败");
        }
//        req.setAttribute("action", "update");
        req.setAttribute("id", id);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?action=update").forward(req, resp);
    }

    protected void page(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));

        Page bookPage = bookService.page(pageNo);
        bookPage.setUrl("manager/bookServlet?action=page");

        req.setAttribute("bookPage", bookPage);

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }
}
