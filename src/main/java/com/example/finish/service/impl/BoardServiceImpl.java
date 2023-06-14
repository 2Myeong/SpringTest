package com.example.finish.service.impl;

import com.example.finish.dao.BoardDAO;
import com.example.finish.dto.BoardDto;
import com.example.finish.dto.BoardResponseDto;
import com.example.finish.dto.ProductResponseDto;
import com.example.finish.entity.Board;
import com.example.finish.entity.Product;
import com.example.finish.entity.User;
import com.example.finish.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {
    private final BoardDAO boardDAO;


    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    //생성
    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) principle;

        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContents(boardDto.getContents());
        board.setUserId(user.getUid());
        board.setUserName(user.getUsername());
        board.setCreatedAt(LocalDateTime.now());
        board.setUpdatedAt(LocalDateTime.now());

        Board saveBoard = boardDAO.insertBoard(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(saveBoard.getId());
        boardResponseDto.setTitle(saveBoard.getTitle());
        boardResponseDto.setContents(saveBoard.getContents());
        return boardResponseDto;
    }
    //수정
    @Override
    public BoardResponseDto changeBoard(Long id, String title, String contents) throws Exception {
        Board changeboard = boardDAO.updateBoard(id, title, contents);
        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(changeboard.getTitle());
        boardResponseDto.setContents(changeboard.getContents());
        return new BoardResponseDto(changeboard);
    }
    // 삭제
    @Override
    public void deleteBoard(Long id) throws Exception {
        boardDAO.deleteBoard(id);
    }

    //모든 게시글 리스트
    @Override
    public List<BoardResponseDto> allBoard() {
        List<Board> boards = boardDAO.allBoard();
        List<BoardResponseDto> boardResponseDtoList = boards.stream().map(board -> new BoardResponseDto(board)).collect(Collectors.toList());
        return boardResponseDtoList;
    }

    //게시글 리스트 - 작성일시 순(내림차순)
    @Override
    public List<BoardResponseDto> listALLBoardByCreatedAt() {
        List<Board> boards = boardDAO.listALLBoardByCreatedAt();
        List<BoardResponseDto> boardResponseDtoList = boards.stream().map(board -> new BoardResponseDto(board)).collect(Collectors.toList());
        return boardResponseDtoList;
    }




    //작성자를 통한 게시글 리스트
    @Override
    public List<BoardResponseDto> getProductByuserName(String userName) {
        List<Board> boards = boardDAO.selectBoardByuserName(userName);
        List<BoardResponseDto> boardResponseDtoList = boards.stream().map(board -> new BoardResponseDto(board)).collect(Collectors.toList());
        return boardResponseDtoList;
    }

    // id를 통해 가지고오기
    @Override
    public BoardResponseDto getboard(Long id) {
        Board board = boardDAO.selectBoard(id);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setUserId(board.getUserId());
        boardResponseDto.setUserName(board.getUserName());

        return boardResponseDto;
    }
}
