package com.example.finish.service;

import com.example.finish.dto.BoardResponseDto;
import com.example.finish.dto.OrderDto;
import com.example.finish.dto.OrderResponseDto;
import com.example.finish.dto.ProductResponseDto;

import java.util.List;

public interface OrderService {

    //상품 주문
    OrderResponseDto saveOrder(OrderDto orderDto);

    //전체 주문 리스트
    List<OrderResponseDto> allOrder();

    //상품별 주문 리스트 - 구매자 id
    List<OrderResponseDto> getOrderByuserName(String userName);

    // 상품별 주문 리스트 - 상품 id
    List<OrderResponseDto> getOrderByproductId(String productId);

    //주문 정보 - 주문 id
    OrderResponseDto getOrder(Long id);
}
