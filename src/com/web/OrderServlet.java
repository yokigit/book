package com.web;

import com.pojo.Cart;
import com.pojo.Order;
import com.pojo.OrderItem;
import com.pojo.User;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: spring5_demo1
 * @author: yoki
 * @create: 2022-04-17 20:56
 */
public class OrderServlet extends BaseServlet {
    private final OrderService orderService = new OrderServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        User user = (User) req.getSession().getAttribute("user");
        if (cart != null && user != null) {
            String order_id = orderService.createOrder(cart, user.getId());

            //为了防止表单重复提交，即创建多个订单，使用请求重定向
            req.getSession().setAttribute("order_id", order_id);
            resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

//            req.setAttribute("order_id", order_id);
//            req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        }
    }

    protected void showMyOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            List<Order> orders = orderService.showMyOrder(user.getId());
            req.setAttribute("orders", orders);
            req.getRequestDispatcher("/pages/order/order.jsp").forward(req, resp);
        }
    }

    protected void showOrderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order_id = req.getParameter("order_id");
        List<OrderItem> orderItems = orderService.showOrderDetails(order_id);
        req.setAttribute("orderItems", orderItems);
        req.getRequestDispatcher("/pages/order/order_details.jsp").forward(req, resp);
    }

    protected void showAllOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.showAllOrder();

        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req, resp);
    }

    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order_id = req.getParameter("order_id");
        orderService.sendOrder(order_id, 1);

        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String order_id = req.getParameter("order_id");
        orderService.receiveOrder(order_id);

        System.out.println(req.getHeader("Referer"));
        resp.sendRedirect(req.getHeader("Referer"));
    }
}