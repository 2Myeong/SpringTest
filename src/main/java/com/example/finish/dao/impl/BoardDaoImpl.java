package com.example.finish.dao.impl;

import com.example.finish.dao.BoardDAO;
import com.example.finish.entity.Board;
import com.example.finish.entity.Product;
import com.example.finish.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BoardDaoImpl implements BoardDAO {
    private final BoardRepository boardRepository;

    @Autowired
    public BoardDaoImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    //생성
    @Override
    public Board insertBoard(Board board) {
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }
    //수정
    @Override
    public Board updateBoard(Long id, String title, String contents) throws Exception {
        Optional<Board> selectBoard = boardRepository.findById(id);
        Board updateBoard;
        if(selectBoard.isPresent()) {
            // update
            Board board = selectBoard.get();
            board.setTitle(title);
            board.setContents(contents);
            board.setUpdatedAt(LocalDateTime.now());
            updateBoard = boardRepository.save(board);
        } else {
            throw new Exception();
        }
        return updateBoard;
    }
    //삭제
    @Override
    public void deleteBoard(Long id) throws Exception {
        Optional<Board> selectBoard = boardRepository.findById(id);
        if(selectBoard.isPresent()) {
            //delete
            Board board = selectBoard.get();
            boardRepository.delete(board);
        } else {
            throw new Exception();
        }
    }

    //모든 게시글 리스트
    @Override
    public List<Board> allBoard() {
        List<Board> allBoard = boardRepository.findAll();
        return allBoard;
    }

    // 등록일자
    @Override
    public List<Board> listALLBoardByCreatedAt() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }


    //작성자를 통한 게시글 리스트
    @Override
    public List<Board> selectBoardByuserName(String userName) {
        List<Board> selectBoard = boardRepository.findByuserName(userName);
        return selectBoard;
    }


    //id를 통해 가지고오기
    @Override
    public Board selectBoard(Long id) {
        boardRepository.findById(id);
        Board selectBoard = boardRepository.getReferenceById(id);
        return selectBoard;
    }

}
