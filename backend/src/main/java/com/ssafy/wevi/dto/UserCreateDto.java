package com.ssafy.wevi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDto {
    private String email;
    private String nickname;
    private String name;
    private String password;
    private String phone;
    private String address;
}
