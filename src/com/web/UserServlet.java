package com.web;

import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;
import com.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-09 21:12
 */
public class UserServlet extends BaseServlet {
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(null, username, password, null);

        user = userService.Login(user);
        if (user != null) {
            System.out.println("登录成功");
            //保存用户登录信息到Session域
            request.getSession().setAttribute("user", user);

            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        } else {

            request.setAttribute("msg", "用户名或密码错误");
            request.setAttribute("username", username);

            System.out.println("用户名或者密码不正确");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String code = req.getParameter("code");

        Map<String, String[]> parameterMap = req.getParameterMap();
        User user = WebUtils.copyParamToBean(new User(), parameterMap);

        if (token.equalsIgnoreCase(code)) {

            if (userService.isExistUsername(user.getUsername())) {
                req.setAttribute("errorMsg", "用户已存在");
                req.setAttribute("username", user.getUsername());
                req.setAttribute("email", user.getEmail());

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
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());

            req.getRequestDispatcher("/pages/user/register.jsp").forward(req, resp);
        }
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //销毁Session,销毁Cookie[JSESSIONID]
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath() + "/index.jsp");
    }
}
