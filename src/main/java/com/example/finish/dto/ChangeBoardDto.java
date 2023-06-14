package com.example.finish.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangeBoardDto {
    private Long id;
    private String title;
    private String contents;

}
