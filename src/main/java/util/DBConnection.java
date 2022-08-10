package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    String url = "jdbc:mysql://localhost:3306/E-COMMERCE";
    String username = "root";
    String dbPassword = "Uchenna:080";

    private Connection dbConnection(){
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username,dbPassword);
            return con;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
