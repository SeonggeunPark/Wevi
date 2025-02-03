package com.ssafy.wevi.dto.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {
    private String nickname;
    private String password;
    private String phone;
    private String zonecode;
    private String autoRoadAddress;
    private String addressDetail;
}
