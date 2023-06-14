package com.example.finish.dao;
import com.example.finish.entity.User;

import java.util.List;

public interface UserDAO {

    //사용자 리스트
    List<User> allUser();

    // 사용자 리스트 - 이름 내림차순
    List<User> listAllUserByName();
}
