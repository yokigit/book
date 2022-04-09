package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-09 21:12
 */
public class UserServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")) {
            Login(req, resp);
        } else {
            Register(req, resp);
        }
    }

    protected void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    protected void Register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        User user = new User(null, username, password, email);

        if ("abcde".equalsIgnoreCase(code)) {

            if (userService.isExistUsername(username)) {
                req.setAttribute("errorMsg", "用户已存在");
                req.setAttribute("username", username);
                req.setAttribute("email", email);

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
            req.setAttribute("errorMsg", "验证码错误");
            req.setAttribute("username", username);
            req.setAttribute("email", email);

            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }
}
