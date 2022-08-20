package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeDao {
    private Connection connection;
    private String query;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public LikeDao(Connection connection) {
        this.connection = connection;
    }

    public boolean addTolike(int user_id, int prod_id) throws SQLException {
        System.out.println("5");
        String addProduct = "SELECT * FROM likes Where userId = ? and productId =?";
        System.out.println("6");
        preparedStatement = connection.prepareStatement(addProduct);
        System.out.println("7");
        preparedStatement.setInt(1, user_id);
        System.out.println("8");
        preparedStatement.setInt(2, prod_id);
        System.out.println("9");
        ResultSet set = preparedStatement.executeQuery();
        System.out.println("77");
        if (set.next()) {
            System.out.println("10");
            String query = "delete from likes where userId = ? and productId = ?";
            System.out.println("11");
            preparedStatement = connection.prepareStatement(query);
            System.out.println("12");
            preparedStatement.setInt(1, user_id);
            System.out.println("13");
            preparedStatement.setInt(2, prod_id);
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                return true;
            }
        } else {
            String addPro = "INSERT INTO likes (userId, productId) VALUES (?, ?)";
            preparedStatement = connection.prepareStatement(addPro);
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, prod_id);
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                return true;
            }
        }
        return false;
    }
}
