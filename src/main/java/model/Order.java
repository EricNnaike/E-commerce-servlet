package model;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order extends ProductModel{
    private int orderId;
    private int userId;
    private int orderQty;
    private String orderDate;

}
