package com.example.finish.dao.impl;

import com.example.finish.dao.OrderDAO;
import com.example.finish.entity.Board;
import com.example.finish.entity.Order;
import com.example.finish.entity.Product;
import com.example.finish.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDaoImpl implements OrderDAO {
    private final OrderRepository orderRepository;
    @Autowired
    public OrderDaoImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    // 주문
    @Override
    public Order insertOrder(Order order) {
        Order saveOrder = orderRepository.save(order);
        return saveOrder;
    }

    // 전체 리스트
    @Override
    public List<Order> allOrder() {
       List<Order> allOrder = orderRepository.findAll();
       return allOrder;
    }

    //상품별 주문 리스트 - 구매자 id
    @Override
    public List<Order> selectOrderByUserName(String userName) {
        List<Order> selectOrder = orderRepository.findByuserName(userName);
        return selectOrder;
    }



    // 상품별 주문 리스트 - 상품 id
    @Override
    public List<Order> selectOrderByProductId(String productId) {
        List<Order> selectOrder = orderRepository.findByproductId(productId);
        return selectOrder;
    }

    //주문 정보 - 주문 id
    @Override
    public Order selectOrder(Long id) {
        orderRepository.findById(id);
        Order selectOrder = orderRepository.getReferenceById(id);
        return selectOrder;
    }
}
