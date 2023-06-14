package com.example.finish.controller;

import com.example.finish.dto.*;
import com.example.finish.entity.User;
import com.example.finish.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }



    //수정
    @PutMapping()
    public ResponseEntity<BoardResponseDto> changeBoard(@RequestBody ChangeBoardDto changeBoardDto) throws Exception {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) principle;

        BoardResponseDto boardResponseDto = boardService.changeBoard(changeBoardDto.getId(), changeBoardDto.getTitle(), changeBoardDto.getContents());
        if(user.getUid().equals(boardResponseDto.getUserId())) {
            return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
    // 생성
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
    public ResponseEntity<BoardResponseDto> createBoard(@RequestBody BoardDto boardDto) {
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    //삭제
    @DeleteMapping()
    public ResponseEntity<String> deleteBoard(Long id) throws Exception {
        Object principle = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) principle;
        BoardResponseDto boardResponseDto = boardService.getboard(id);
        if(user.getUid().equals(boardResponseDto.getUserId())) {
            return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //모든 게시글 리스트
    @GetMapping("/list")
    public ResponseEntity<List<BoardResponseDto>> allBoard( ) {
        List<BoardResponseDto> boardResponseDto = boardService.allBoard();
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    //게시글 리스트 - 작성일시 순(내림차순)
    @GetMapping("/listOrderByCreatedAt")
    public ResponseEntity<List<BoardResponseDto>> listALLBoardByCreatedAt() {
        List<BoardResponseDto> boardResponseDto = boardService.listALLBoardByCreatedAt();
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    //작성자를 통한 게시글 리스트
    @GetMapping("/byUserName")
    public ResponseEntity<List<BoardResponseDto>> getBoardByuserName(String userName) {
        return ResponseEntity.status(HttpStatus.OK).body(boardService.getProductByuserName(userName));
    }
    //id를 통한 리스트
    @GetMapping("/")
    public ResponseEntity<BoardResponseDto> getboard(Long id) {
        BoardResponseDto boardResponseDto = boardService.getboard(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }
}
