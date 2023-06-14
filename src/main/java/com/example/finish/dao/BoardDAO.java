package com.example.finish.dao;

import com.example.finish.entity.Board;
import com.example.finish.entity.Product;

import java.util.List;

public interface BoardDAO {
    // 생성
    Board insertBoard(Board board);

    // 수정
    Board updateBoard(Long id, String title, String contents) throws Exception;

    // 삭제
    void deleteBoard(Long id) throws Exception;

    //게시글 리스트
    List<Board> allBoard();

    //게시글 리스트 - 작성일시 순(내림차순)
    List<Board> listALLBoardByCreatedAt();

    //작성자를 통한 게시글 리스트
    List<Board> selectBoardByuserName(String userName);

    //아이디를 통해 가지고오기
    Board selectBoard(Long id);
}
