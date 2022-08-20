package com.example.ecommerceapp;

import model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "CartServlet", value = "/CartServlet")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTf-8");
        try(PrintWriter out = response.getWriter()) {
            ArrayList<Cart> cartList = new ArrayList<>();

            //Getting product Id from the brouser URL
            int id = Integer.parseInt(request.getParameter("id"));
            Cart cart = new Cart();
            cart.setId(id);
            cart.setCartQuantity(1);

            HttpSession session = request.getSession();
            ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

            if (cart_list == null) {
                cartList.add(cart);
                session.setAttribute("cart-list", cartList);
                response.sendRedirect("index.jsp");
            }else {
                //if product allready exist in car
                boolean exist = false;
                cartList = cart_list;
                for (Cart list : cart_list) {
                    if (list.getId() == id) {
                        exist = true;
                        out.println("<h3 style='color: crimson; text-align: center'>Item already exists in cart<a href='cart.jsp'>  Go to cart page</a></h3>");
                    }
                }
                if (!exist) {
                    cartList.add(cart);
                    response.sendRedirect("index.jsp");
                }
            }

        }
    }
}
