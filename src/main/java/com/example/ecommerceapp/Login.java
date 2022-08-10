package com.example.ecommerceapp;

import dao.LoginDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/Login")

public class Login extends HttpServlet {
    LoginDao dao = new LoginDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uname = request.getParameter("uname");
        String pass = request.getParameter("pass");


        try {
            if (dao.checkLogin(uname, pass)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", uname);

                response.sendRedirect("index.jsp");
            }else {
                response.sendRedirect("ulogin.jsp");
                System.out.printf("Error occured");
            }
        } catch (SQLException e) {
            System.err.println(e.getCause().getLocalizedMessage());
            throw new RuntimeException(e);
        }

    }
}
