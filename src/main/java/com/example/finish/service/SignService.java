package com.example.finish.service;

import com.example.finish.dto.SignInResultDto;
import com.example.finish.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;
}
