package com.example.ecommerceapp;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SignUpDao;
import model.User;
import util.DatabaseConnection;

@WebServlet("/Signup")
public class AddCustomer extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Retrieving values from the frontend
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String pincode = request.getParameter("pincode");


        User user = new User(name, email, password, mobile, gender, address, pincode);

        SignUpDao signUpDao = new SignUpDao();
        try {
            if(signUpDao.signUp(user)) {
                response.sendRedirect("signup.jsp?msg=valid");
            } else {
                response.sendRedirect("signup.jsp?msg=invalid");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        //Creating Session
//        HttpSession hs = request.getSession();
        
        //Inserting all values inside the database

    }
}
