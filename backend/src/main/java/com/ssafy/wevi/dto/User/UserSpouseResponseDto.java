package com.ssafy.wevi.dto.User;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserSpouseResponseDto {
    private Integer spouseId;
    private String nickname;
    private String name;
}
