package com.example.finish.service;

import com.example.finish.dto.ProductResponseDto;
import com.example.finish.dto.UserResponseDto;

import java.util.List;

public interface UserService {

    //사용자 전체 리스트
    List<UserResponseDto> allUser();

    //사용자 리스트 - 이름 내림차순
    List<UserResponseDto> listAllUserByName();
}
