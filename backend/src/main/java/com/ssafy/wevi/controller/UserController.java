package com.ssafy.wevi.controller;

import com.ssafy.wevi.config.SecurityUtils;
import com.ssafy.wevi.dto.UserCreateDto;
import com.ssafy.wevi.dto.UserResponseDto;
import com.ssafy.wevi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolderStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    // CREATE는 Optional일 수가 없으므로 할 필요 X
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto create(@RequestBody UserCreateDto userCreateDto) {

        UserResponseDto userResponseDto = userService.create(userCreateDto);
        return userResponseDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Integer id) {
        // 유저 ID 가져오기
        String userId = SecurityUtils.getAuthenticatedUserId();

        if (!Objects.equals(userId, String.valueOf(id))) {
            throw new AccessDeniedException("User ID: " + userId + " does not match ID: " + id);
        }
        UserResponseDto userResponseDto = userService.findById(id).orElseThrow();
        return ResponseEntity.ok(userResponseDto);
    }


//    @GetMapping("/{email}")
//    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email) {
//        UserResponseDto userResponseDto = userService.findByEmail(email).orElseThrow();
//        return ResponseEntity.ok(userResponseDto);
//    }
}
