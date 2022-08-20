package com.example.ecommerceapp;

import model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "QtyIncreDecreServlet", value = "/QtyIncreDecreServlet")
public class QtyIncreDecreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try(PrintWriter out = response.getWriter()) {
            String action = request.getParameter("action");
            int id = Integer.parseInt(request.getParameter("id"));

            HttpSession session = request.getSession();
            ArrayList<Cart> cartList1 = (ArrayList<Cart>) session.getAttribute("cart-list");

            if (action != null && id >= 1) {
                if (action.equals("incre")) {
                    for (Cart c: cartList1) {
                        if (c.getId() == id) {
                            int qty = c.getCartQuantity();
                            qty++;
                            c.setCartQuantity(qty);
                            response.sendRedirect("cart.jsp");
                        }
                    }
                }
                if (action.equals("decre")) {
                    for (Cart c: cartList1) {
                        if (c.getId() == id && c.getCartQuantity() > 1) {
                            int qty = c.getCartQuantity();
                            qty--;
                            c.setCartQuantity(qty);
                            response.sendRedirect("cart.jsp");
                        }
                    }

                }
            }
            else {
                response.sendRedirect("cart.jsp");
            }
        }
    }
}
