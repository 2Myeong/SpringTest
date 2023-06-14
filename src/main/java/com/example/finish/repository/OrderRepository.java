package com.example.finish.repository;

import com.example.finish.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    //상품별 주문 리스트 - 구매자 id
    List<Order> findByuserName(String userName);

    // 상품별 주문 리스트 - 상품 id
    List<Order> findByproductId(String productId);

    //주문 정보 - 주문 id
}
