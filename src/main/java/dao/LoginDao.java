package dao;


import model.User;
import util.DatabaseConnection;

import java.sql.*;


public class LoginDao {
    User user = new User();
    public User fetchLoginFromDB(String uname, String pass) throws SQLException{
        try {
            Connection con = DatabaseConnection.getConnection();

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM tblcustomer WHERE email=? and password=?");
            stmt.setString(1, uname);
            stmt.setString(2, pass);
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String email = rs.getString("email");
                String passWORD = rs.getString("password");
                user = new User(email, passWORD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
