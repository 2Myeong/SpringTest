package com.example.finish.service.impl;

import com.example.finish.dao.UserDAO;
import com.example.finish.dto.ProductResponseDto;
import com.example.finish.dto.UserResponseDto;
import com.example.finish.entity.Product;
import com.example.finish.entity.User;
import com.example.finish.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // 사용자 리스트 - 전체
    @Override
    public List<UserResponseDto> allUser() {
        List<User> users = userDAO.allUser();
        List<UserResponseDto> userResponseDtoList = users.stream().map(user -> new UserResponseDto(user)).collect(Collectors.toList());
        return userResponseDtoList;
    }

    //사용자 리스트 - 이름 내림차순
    @Override
    public List<UserResponseDto> listAllUserByName() {
        List<User> users = userDAO.listAllUserByName();
        List<UserResponseDto> userResponseDtoList = users.stream().map(user -> new UserResponseDto(user)).collect(Collectors.toList());
        return userResponseDtoList;
    }
}
