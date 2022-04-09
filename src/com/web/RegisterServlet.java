package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = new User(null, username, password, email);

        if ("abcde".equalsIgnoreCase(code)) {


            if (userService.isExistUsername(username)) {
                req.setAttribute("errorMsg","用户已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);

                req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
            } else {

                if (userService.register(user)) {
                    System.out.println("注册成功");
                    req.getRequestDispatcher("/pages/user/register_success.jsp").forward(req, resp);
                } else {
                    System.out.println("数据库操作失败，注册失败");
                    req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
                }
            }
        } else {
            req.setAttribute("errorMsg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);

            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }
}
