package com.example.finish.dto;

import com.example.finish.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto(Product product) {
        this.number = product.getNumber();
        this.name = product.getName();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }

}