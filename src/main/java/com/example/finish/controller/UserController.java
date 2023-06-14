package com.example.finish.controller;


import com.example.finish.dto.ProductResponseDto;
import com.example.finish.dto.UserResponseDto;
import com.example.finish.service.OrderService;
import com.example.finish.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 사용자 라스트 - 전체
    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> allUser( ) {
        List<UserResponseDto> userResponseDto = userService.allUser();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    //사용자 르스트 - 이름 내림차순
    @GetMapping("/listOrderByName")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<UserResponseDto>> listAllUserByPrice() {
        List<UserResponseDto> userResponseDto = userService.listAllUserByName();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

}