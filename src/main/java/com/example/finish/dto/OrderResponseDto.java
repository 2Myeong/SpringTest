package com.example.finish.dto;

import com.example.finish.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Long id;
    private String productId;
    private String productName;
    private String userId;
    private String userName;
    private int price;

    public OrderResponseDto(Order order) {
        this.id = order.getId();
        this.productId = order.getProductId();
        this.productName = order.getProductName();
        this.userId = order.getUserId();
        this.userName = order.getUserName();
        this.price = order.getPrice();
    }
}
