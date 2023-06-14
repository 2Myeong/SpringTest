package com.example.finish.dao.impl;

import com.example.finish.dao.ProductDAO;
import com.example.finish.dao.UserDAO;
import com.example.finish.entity.Product;
import com.example.finish.entity.User;
import com.example.finish.repository.ProductRepository;
import com.example.finish.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoImpl implements UserDAO {
    private final UserRepository userRepository;
    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //사용자 리스트(전체)
    @Override
    public List<User> allUser() {
        List<User> allUser = userRepository.findAll();
        return  allUser;
    }

    //사용자 리스트 - 이름 내림차순
    @Override
    public List<User> listAllUserByName() {
        return userRepository.findAllByOrderByNameAsc();
    }


}
