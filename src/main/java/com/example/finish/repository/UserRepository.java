package com.example.finish.repository;

import com.example.finish.entity.Product;
import com.example.finish.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUid(String uid);

    List<User> findAllByOrderByNameAsc();

}
