package com.example.ecommerceapp;

import dao.LoginDao;
import model.User;
import util.DatabaseConnection;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/Login")
public class UserLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        LoginDao loginDao = new LoginDao();

        HttpSession session = request.getSession();
        try {
            User user = loginDao.fetchLoginFromDB(email, pass);
            String emailFromDB = user.getEmail();
            String passwordFromDB = user.getPassword();
            if (emailFromDB.equals(email) && passwordFromDB.equals(pass)) {
                session.setAttribute("email" , email);
                response.sendRedirect("index.jsp");
            }
            else {
                response.sendRedirect("ulogin.jsp");
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
