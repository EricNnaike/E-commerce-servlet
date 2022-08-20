package com.example.ecommerceapp;

import dao.LikeDao;
import model.User;
import util.DatabaseConnection;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LikeServlet", value = "/LikeServlet")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        System.out.println("1");
      User user = new User();
        System.out.println("2");
        try{
            LikeDao likeDao = new LikeDao(DatabaseConnection.getConnection());
            System.out.println("3");
            likeDao.addTolike(user.getId(), productId);
            System.out.println("4");
            response.sendRedirect("index.jsp");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
