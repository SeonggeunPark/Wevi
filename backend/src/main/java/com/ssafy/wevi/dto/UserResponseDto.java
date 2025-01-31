package com.ssafy.wevi.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDto {
    private Integer id;
    private String email;
    private String authProvider;
    private String nickname;
    private String name;
    private String phone;
    private String address;
    private LocalDateTime createdAt;
}
