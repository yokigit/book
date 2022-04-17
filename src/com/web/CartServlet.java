package com.web;

import com.pojo.Book;
import com.pojo.Cart;
import com.pojo.CartItem;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-16 16:30
 */
public class CartServlet extends BaseServlet {
    private final BookService bookService = new BookServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置服务器字符集为 UTF-8
        resp.setCharacterEncoding("UTF-8");
        // 通过响应头，设置浏览器也使用 UTF-8 字符集
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取bookId
        String id = req.getParameter("id");
        //查找并返回Book对象
        Book book = bookService.queryBook(Integer.parseInt(id));
        //通过Book对象的信息，封装CartItem,
        CartItem item = new CartItem(book.getId(), book.getName(), 1, book.getPrice());

        //将Cart购物车信息保存到Session域
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            cart.addItem(item);
            req.getSession().setAttribute("cart", cart);
        } else {
            //******** 从Session域获取的对象cart，操作数据addItem() 后，Session域中的对象的数据随之改变
            cart.addItem(item);
        }

        //该图书库存 stock--
        book.setStock(book.getStock() - 1);
        bookService.updateBook(book);

        //返回当前页
//        resp.sendRedirect(req.getHeader("Referer"));
        String pageNo = req.getParameter("pageNo");
        String bookName = book.getName();
        //解决get请求参数乱码
        bookName = URLEncoder.encode(bookName, StandardCharsets.UTF_8);
        resp.sendRedirect(req.getContextPath() + "/clientBookServlet?action=page&pageNo=" + pageNo + "&bookName=" + bookName);
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        if (id != 0) {
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.deleteItem(id);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        cart.clear();
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 0);
        if (id != 0) {
            Cart cart = (Cart) req.getSession().getAttribute("cart");
            cart.updateCount(id, count);
        }
        resp.sendRedirect(req.getHeader("Referer"));
    }
}
