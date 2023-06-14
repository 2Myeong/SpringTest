package com.example.finish.repository;

import com.example.finish.entity.Board;
import com.example.finish.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByOrderByCreatedAtDesc();

    List<Board> findByuserName(String userName);



}
