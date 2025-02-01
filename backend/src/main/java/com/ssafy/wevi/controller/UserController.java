package com.ssafy.wevi.controller;

import com.ssafy.wevi.config.SecurityUtils;
import com.ssafy.wevi.dto.ApiResponseDto;
import com.ssafy.wevi.dto.User.UserCreateDto;
import com.ssafy.wevi.dto.User.UserResponseDto;
import com.ssafy.wevi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    // CREATE는 Optional일 수가 없으므로 Optional 벗길 필요 X
    // 회원가입
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<UserResponseDto> create(@RequestBody UserCreateDto userCreateDto) {
        UserResponseDto userResponseDto = userService.create(userCreateDto);

        return new ApiResponseDto<>(
                HttpStatus.CREATED.value(),
                true,
                "User created successfully",
                userResponseDto
        );
    }

    // 본인 유저 정보 조회하기
    @GetMapping
    public ApiResponseDto<UserResponseDto> getUser() {
        // 로그인한 유저 ID 가져오기
        String userId = SecurityUtils.getAuthenticatedUserId();

        UserResponseDto userResponseDto = userService.findById(Integer.valueOf(userId)).orElseThrow();

        return new ApiResponseDto<>(
                HttpStatus.OK.value(),
                true,
                "User found by auth successfully",
                userResponseDto
        );
    }

    // 다른 유저 정보 조회하기
    @GetMapping("/{id}")
    public ApiResponseDto<UserResponseDto> getUserById(@PathVariable Integer id) {
        UserResponseDto userResponseDto = userService.findById(id).orElseThrow();

        return new ApiResponseDto<>(
                HttpStatus.OK.value(),
                true,
                "User found by id successfully",
                userResponseDto
        );
    }
}
