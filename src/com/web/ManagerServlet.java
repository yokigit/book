package com.web;

import com.pojo.Manager;
import com.service.ManagerService;
import com.service.impl.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-20 10:07
 */
public class ManagerServlet extends BaseServlet {
    private final ManagerService managerService = new ManagerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Manager manager = managerService.login(username, password);

        if (manager != null) {
            req.getSession().setAttribute("manager", manager);
            resp.sendRedirect(req.getContextPath() + "/pages/manager/manager.jsp");
        } else {
            req.setAttribute("username", username);
            req.setAttribute("msg", "用户名或密码不正确!");
            req.getRequestDispatcher("/pages/manager/login.jsp").forward(req, resp);
        }
    }
}
