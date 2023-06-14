package com.example.finish.dto;

import com.example.finish.entity.Order;
import com.example.finish.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponseDto {
    private Long id;
    private String uid;
    private String name;
    private String email;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.uid = user.getUid();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
