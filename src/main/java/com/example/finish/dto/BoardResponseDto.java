package com.example.finish.dto;

import com.example.finish.entity.Board;
import com.example.finish.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String userId;
    private String userName;

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.contents = board.getContents();
        this.userId = board.getUserId();
        this.userName = board.getUserName();
    }
}
