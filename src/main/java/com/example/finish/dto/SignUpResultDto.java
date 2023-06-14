package com.example.finish.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SignUpResultDto {

    private boolean success;
    private int code;
    private String msg;
}
