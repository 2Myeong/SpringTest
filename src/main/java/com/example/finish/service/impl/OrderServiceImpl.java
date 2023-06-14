package com.example.finish.service.impl;

import com.example.finish.dao.OrderDAO;
import com.example.finish.dto.BoardResponseDto;
import com.example.finish.dto.OrderDto;
import com.example.finish.dto.OrderResponseDto;
import com.example.finish.dto.ProductResponseDto;
import com.example.finish.entity.Board;
import com.example.finish.entity.Order;
import com.example.finish.entity.Product;
import com.example.finish.entity.User;
import com.example.finish.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderDAO orderDAO;
    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    //주문
    @Override
    public OrderResponseDto saveOrder(OrderDto orderDto) {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) principle;

        Order order = new Order();
        order.setProductId(orderDto.getProductId());
        order.setProductName(orderDto.getProductName());
        order.setUserId(user.getUid());
        order.setUserName(user.getUsername());
        order.setPrice(orderDto.getPrice());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDAO.insertOrder(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(saveOrder.getId());
        orderResponseDto.setProductId(saveOrder.getProductId());
        orderResponseDto.setProductName(saveOrder.getProductName());
        orderResponseDto.setPrice(saveOrder.getPrice());
        return orderResponseDto;
    }
    //전체 리스트
    @Override
    public List<OrderResponseDto> allOrder() {
        List<Order> orders = orderDAO.allOrder();
        List<OrderResponseDto> orderResponseDtoList = orders.stream().map(order -> new OrderResponseDto(order)).collect(Collectors.toList());
        return orderResponseDtoList;
    }



    //상품별 주문 리스트 - 구매자 id
    @Override
    public List<OrderResponseDto> getOrderByuserName(String userName) {
        List<Order> orders = orderDAO.selectOrderByUserName(userName);
        List<OrderResponseDto> orderResponseDtoList = orders.stream().map(order -> new OrderResponseDto(order)).collect(Collectors.toList());
        return orderResponseDtoList;
    }


    // 상품별 주문 리스트 - 상품 id
    @Override
    public List<OrderResponseDto> getOrderByproductId(String productId) {
        List<Order> orders = orderDAO.selectOrderByProductId(productId);
        List<OrderResponseDto> orderResponseDtoList = orders.stream().map(order -> new OrderResponseDto(order)).collect(Collectors.toList());
        return orderResponseDtoList;
    }

    //주문 정보 - 주문 id
    @Override
    public OrderResponseDto getOrder(Long id) {
        Order order = orderDAO.selectOrder(id);
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setUserId(order.getUserId());
        orderResponseDto.setUserName(order.getUserName());
        orderResponseDto.setProductId(order.getProductId());
        orderResponseDto.setProductName(order.getProductName());
        orderResponseDto.setPrice(order.getPrice());
        return orderResponseDto;
    }
}

