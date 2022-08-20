package model;

public class Likes {
    private User userId;
    private ProductModel productId;

    public Likes(User userId, ProductModel productId) {
        this.userId = userId;
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public ProductModel getProductId() {
        return productId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setProductId(ProductModel productId) {
        this.productId = productId;
    }
}
