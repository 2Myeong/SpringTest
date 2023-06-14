package com.example.finish.dao;

import com.example.finish.entity.Product;

import java.util.List;

public interface ProductDAO {
    Product insertProduct(Product product);
    Product updateProductName(Long number, String name, int price, int stock) throws  Exception;
    void deleteProduct(Long number) throws Exception;


    List<Product> allProduct();

    List<Product> listAllProductByPrice();

    List<Product> listProductByName(String name);
    Product selectProduct(Long number);
}
