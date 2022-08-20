package dao;

import model.Cart;
import model.ProductModel;
import util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
    private String query;
    private PreparedStatement statement;
    private ResultSet resultSet;
    public Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }

    public ProductDao() {
    }

    public boolean addProduct(ProductModel productModel) {
        boolean result = false;
        try {
            query = "INSERT INTO tblproduct(id, name, active, image, image_name, price, product_category, quantity) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement st = DatabaseConnection.getConnection().prepareStatement(query);

            st.setInt(1, productModel.getId());
            st.setString(2, productModel.getName());
            st.setString(3, productModel.getActive());
            st.setString(4, productModel.getImage());
            st.setString(5, productModel.getImage_name());
            st.setDouble(6, productModel.getPrice());
            st.setString(7, productModel.getProduct_category());
            st.setInt(8, productModel.getQuantity());

            int rs = st.executeUpdate();
            if (rs > 0) {
                result = true;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public List<ProductModel> getAllProduct() {
        List<ProductModel> productList = new ArrayList<>();
        try {
            query = "SELECT * FROM tblproduct";
            statement = DatabaseConnection.getConnection().prepareStatement(query);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String active = resultSet.getString("active");
                String image = resultSet.getString("image");
                String image_name = resultSet.getString("image_name");
                Double price = resultSet.getDouble("price");
                String category = resultSet.getString("product_category");
                int qty = resultSet.getInt("quantity");
                ProductModel row = new ProductModel(id, name, active, image, image_name, price, category, qty);
                productList.add(row);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    public List<Cart> getCartProduct(ArrayList<Cart> cartList) {
        ArrayList<Cart> produsts = new ArrayList<Cart>();
            try {
                if (cartList.size() > 0) {
                    for (Cart list : cartList) {
                        query = "SELECT * FROM tblproduct WHERE id = ?";
                        statement = con.prepareStatement(query);
                        statement.setInt(1, list.getId());
                        System.out.println("before");
                        resultSet = statement.executeQuery();
                        System.out.println("after");
                       if (resultSet.next()) {
                           Cart cart = new Cart();
                           cart.setId(resultSet.getInt("id"));
                           cart.setName(resultSet.getString("name"));
                           cart.setActive(resultSet.getString("active"));
                           cart.setImage(resultSet.getString("image"));
                           cart.setPrice(resultSet.getDouble("price")* list.getCartQuantity());
                           cart.setProduct_category(resultSet.getString("product_category"));
                           cart.setCartQuantity(list.getCartQuantity());
                            produsts.add(cart);
                       }
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        return produsts;
    }

    public double getTotalCartPrice(ArrayList<Cart> cartList2) {
            double totalPrice = 0;
            try {
                if (cartList2 != null) {
                    for (Cart item: cartList2) {
                        query = "SELECT price FROM tblproduct WHERE id = ?";
                        statement = con.prepareStatement(query);
                        statement.setInt(1, item.getId());
                        resultSet = statement.executeQuery();
                        while (resultSet.next()) {
                            totalPrice += resultSet.getDouble("price")*item.getCartQuantity();
                        }
                    }
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return totalPrice;
    }

}


