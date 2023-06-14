package com.example.finish.service;

import com.example.finish.dto.BoardDto;
import com.example.finish.dto.BoardResponseDto;
import com.example.finish.dto.ProductDto;
import com.example.finish.dto.ProductResponseDto;

import java.util.List;

public interface BoardService {

    // 게시판 정보 저장(생성)
    BoardResponseDto saveBoard(BoardDto boardDto);

    //수정
    BoardResponseDto changeBoard(Long id, String title, String contents) throws Exception;

    //삭제
    void deleteBoard(Long id) throws Exception;

    //모든 게시글 리스트
    List<BoardResponseDto> allBoard();

    //게시글 리스트 - 작성일시 순(내림차순)
    List<BoardResponseDto> listALLBoardByCreatedAt();

    //작성자를 통한 게시글 리스트
    List<BoardResponseDto> getProductByuserName(String userName);

    //id를 통해 가지고오기
    BoardResponseDto getboard(Long id);
}
