package com.example.finish.repository;

import com.example.finish.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByOrderByPriceDesc();

    List<Product> findByNameOrderByPriceDesc(String name);
}
