package com.web;

import com.pojo.Page;
import com.service.BookService;
import com.service.impl.BookServiceImpl;
import com.utils.WebUtils;
import org.jetbrains.annotations.NotNull;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-13 19:21
 */
public class ClientBookServlet extends BaseServlet {
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

    protected void page(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));

        Page bookPage = bookService.page(pageNo);
        bookPage.setUrl("clientBookServlet?action=page");

        req.setAttribute("bookPage", bookPage);

        req.getRequestDispatcher("/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(@NotNull HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pagNo = WebUtils.parseInt(req.getParameter("pageNo"), 0);

        double min = WebUtils.parseDouble(req.getParameter("min"), 0);
        double max = WebUtils.parseDouble(req.getParameter("max"), Integer.MAX_VALUE);

        Page bookPage = bookService.pageByPrice(pagNo, min, max);

        StringBuilder sb=new StringBuilder();
        sb.append("clientBookServlet?action=pageByPrice");

        if (req.getParameter("min") != null) {
            sb.append("&min=").append(min);
        }
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(max);
        }
        bookPage.setUrl(sb.toString());

        req.setAttribute("bookPage", bookPage);

        req.getRequestDispatcher("/client/index.jsp").forward(req, resp);
    }
}
