package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductModel {
    private int id;
    private String name;
    private String active;
    private String image;
    private String image_name;
    private Double price;
    private String product_category;
    private int quantity;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active='" + active + '\'' +
                ", image='" + image + '\'' +
                ", image_name='" + image_name + '\'' +
                ", price='" + price + '\'' +
                ", product_category='" + product_category + '\'' +
                '}';
    }
}
