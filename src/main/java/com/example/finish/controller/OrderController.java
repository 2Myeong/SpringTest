package com.example.finish.controller;

import com.example.finish.dto.BoardResponseDto;
import com.example.finish.dto.OrderDto;
import com.example.finish.dto.OrderResponseDto;
import com.example.finish.dto.ProductResponseDto;
import com.example.finish.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    //주문
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderDto orderDto) {
        OrderResponseDto orderResponseDto = orderService.saveOrder(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    //전체 리스트
    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> allOrder( ) {
        List<OrderResponseDto> orderResponseDto = orderService.allOrder();
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    //상품별 주문 리스트 - 구매자 id
    @GetMapping("/listByUserId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> getOrderByuserName(String userName) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByuserName(userName));
    }

    // 상품별 주문 리스트 - 상품 id
    @GetMapping("/listByProductId")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<OrderResponseDto>> getOrderByproductId(String productId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getOrderByproductId(productId));
    }

    //주문 정보 - 주문 id
    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<OrderResponseDto> getOrder(Long id) {
        OrderResponseDto orderResponseDto = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }
}

