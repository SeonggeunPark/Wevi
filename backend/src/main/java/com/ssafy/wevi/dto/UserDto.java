package com.ssafy.wevi.dto;

import com.ssafy.wevi.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Integer id;
    private String email;
    private String authId;
    private String authProvider;
    private String nickname;
    private String name;
    private String password;
    private String phone;
    private String address;
    private String status;
    private LocalDateTime createdAt;
}
