package ru.flamexander.spring.security.jwt.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDtoAuth {
    private Long id;
    private String username;
    private String email;
    private String token;
}
