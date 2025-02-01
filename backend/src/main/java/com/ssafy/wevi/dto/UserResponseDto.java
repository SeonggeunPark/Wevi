package com.ssafy.wevi.dto;

import com.ssafy.wevi.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResponseDto {
    private Integer userId;
    private String email;
    private String nickname;
    private String name;
    private String phone;
    private String zonecode;
    private String autoRoadAddress;
    private String addressDetail;
    private LocalDateTime createdAt;
    private User spouse;
}
