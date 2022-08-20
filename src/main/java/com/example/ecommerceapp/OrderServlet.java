package com.example.ecommerceapp;

import dao.OrderDao;
import model.Cart;
import model.Order;
import model.User;
import util.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@WebServlet(name = "OrderNowServlet", value = "/OrderNowServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(PrintWriter out = response.getWriter()) {
            System.out.println("1");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            System.out.println(date);

//            User user = (User) request.getSession().getAttribute("email");
           HttpSession session = request.getSession();
           User user = new User();
            System.out.println("hello");
            if (session.getAttribute("email") != null) {
                int proId = Integer.parseInt(request.getParameter("id"));
                int qtyFromFormInput = Integer.parseInt(request.getParameter("quantity"));
                if (qtyFromFormInput <= 0) {
                    qtyFromFormInput = 1;
                }

                Order order = new Order();
                order.setId(proId);
                order.setUserId(user.getId());
                order.setOrderQty(qtyFromFormInput);
                order.setOrderDate(simpleDateFormat.format(date));

                OrderDao orderDao = new OrderDao(DatabaseConnection.getConnection());
                boolean result = orderDao.inserOrder(order);
                if (result) {
                    ArrayList<Cart> cart_list1 = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
                    if (cart_list1 != null) {
                        for (Cart c: cart_list1) {
                            if (c.getId() == proId) {
                                cart_list1.remove(cart_list1.indexOf(c));
                                break;
                            }
                        }
                        response.sendRedirect("orders.jsp");
                    }
                }else {
                    out.println("Order failed");
                }


            }else {
                response.sendRedirect("ulogin.jsp");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
