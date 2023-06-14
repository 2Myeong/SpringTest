package com.example.finish.dao;

import com.example.finish.entity.Board;
import com.example.finish.entity.Order;
import com.example.finish.entity.Product;

import java.util.List;

public interface OrderDAO {

    //생성
    Order insertOrder(Order order);

    // 전체리스트
    List<Order> allOrder();

    //상품별 주문 리스트 - 구매자 id
    List<Order> selectOrderByUserName(String userName);


    // 상품별 주문 리스트 - 상품 id
    List<Order> selectOrderByProductId(String productId);

    //주문 정보 - 주문 id
    Order selectOrder(Long id);

}
