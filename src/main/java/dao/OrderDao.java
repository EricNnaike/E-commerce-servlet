package dao;

import model.Order;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderDao {
    private String query;
    private PreparedStatement statement;
    private ResultSet resultSet;
    public Connection con;

    public OrderDao(Connection con) {
        this.con = con;
    }

    public boolean inserOrder(Order order) {
        boolean result = false;
        try {
            query = "INSERT INTO tblorder(productId, userId, orderQty, orderDate) VALUES(?,?,?,?)";
            con = DatabaseConnection.getConnection();
            statement = this.con.prepareStatement(query);
            statement.setInt(1, order.getId());
            System.out.println("order 1");
            statement.setInt(2, order.getUserId());
            System.out.println("order 2");
            statement.setInt(3, order.getOrderQty());
            System.out.println("order 3");
            statement.setString(4, order.getOrderDate());
            System.out.println("order 4");
             int rs = statement.executeUpdate();
            System.out.println(statement);
            result = true;
            System.out.println("true");

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}
