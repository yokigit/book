package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    private final UserService userService = new UserServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(null, username, password, null);
        if (userService.Login(user) != null) {
            System.out.println("登录成功");
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {

            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);

            System.out.println("用户名或者密码不正确");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
