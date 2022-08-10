package dao;

import java.sql.*;

public class LoginDao {
    String sql = "SELECT * FROM login WHERE NAME= ? && PASSWORD= ?";
    public boolean checkLogin(String uname, String pass) throws SQLException{

        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC&createDatabaseIfNotExist=true","root","1234");

            System.out.println("I came here 1");
            PreparedStatement stmt = con.prepareStatement(sql);
            System.out.println("I came after sql");
            stmt.setString(1, uname);
            System.out.println("------");
            stmt.setString(2, pass);
            System.out.println("I came after name and pass");
//            ResultSet rs = stmt.executeQuery();
            rs = stmt.executeQuery(sql);
            System.out.println("I came here 2");

            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.printf("connection failed");
        }
        finally {
            rs.close();
        }
        return false;
    }
}
