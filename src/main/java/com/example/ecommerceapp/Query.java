//package com.example.ecommerceapp;
//
//import java.sql.*;
//
//public class Query {
//    public static void main(String[] args) throws SQLException {
//        //CREATE A CONNECTION TO DB
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/E-COMMERCE",username,dbPassword);
//            PreparedStatement stmt = con.prepareStatement(sql);
//            stmt.setString(1, uname);
//            stmt.setString(2, pass);
//            ResultSet rs = stmt.executeQuery();
//
//            if (rs.next()) {
//                return true;
//            }
//        } catch (Exception e) {
//            System.out.printf("connection failed");
//        }
//        return false;
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/E-COMMERCE", "root", "Uchenna:080");
//
//        //CREATE A STATEMENT/QUERY
//        Statement stmt = con.createStatement();
//        String query = "INSERT INTO login VALUES(1, 'Bekee', be)";
//        String queryUpdate = "UPDATE student " +
//                "SET name = 'DAVID' " +
//                "WHERE student_id = 2";
//
//        //EXECUTE STATEMENT/QUERY
//        stmt.execute(query);
//
//        //CLOSE CONNECTION
//        con.close();
//
//        System.out.println("Query executed...");
//
//
//    }
//}
