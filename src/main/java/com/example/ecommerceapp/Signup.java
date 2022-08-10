package com.example.ecommerceapp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("pass");
        String address = "";
        String city = "";
        String state = "";
        String country = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true","root","1234");


            PreparedStatement createTable;
            String query = "CREATE TABLE IF NOT EXISTS user("
                    + "id serial, "
                    + "NAME VARCHAR(225) NOT NULL, "
                    + "EMAIL VARCHAR(225) NOT NULL UNIQUE , "
                    + "PHONE VARCHAR(225) NOT NULL, "
                    + "PASSWORD VARCHAR(225) NOT NULL, "
                    + "ADDRESS VARCHAR(225),"
                    + "CITY VARCHAR(225),"
                    + "STATE VARCHAR(225),"
                    + "COUNTRY VARCHAR(225),"
                    + "PRIMARY KEY (id) )";


                createTable = con.prepareStatement(query);
                createTable.execute();
                System.out.println("Table created successfully.");


            PreparedStatement stmt = con.prepareStatement("INSERT INTO user(NAME, EMAIL, PHONE, PASSWORD, ADDRESS, CITY, STATE, COUNTRY) VALUES(?,?,?,?,?,?,?,?)");

            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, phone);
            stmt.setString(4, password);
            stmt.setString(5, address);
            stmt.setString(6, city);
            stmt.setString(7, state);
            stmt.setString(8, country);

            stmt.executeUpdate();
            response.sendRedirect("signup.jsp?msg=valid");


        }  catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("signup.jsp?msg=invalid");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
