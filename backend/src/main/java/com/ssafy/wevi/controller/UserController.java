package com.ssafy.wevi.controller;

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
    // SecurityContext: 인증정보가 담겨있는 틀
    // SecurityContextHolder: 틀이 담겨있는 장소
    private static final SecurityContextHolderStrategy securityContextHolderStrategy = SecurityContextHolder.getContextHolderStrategy();

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
        // 현재 요청의 인증 정보 가져오기
        Authentication authentication = securityContextHolderStrategy.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new AccessDeniedException("Access denied");
        }

        // 인증 정보 안에서 userId 가져오기 (UserDetailsService.loadUserByUsername 메서드에서 리턴한 UserDetails.getUsername의 값)
        String userId = authentication.getName();

        if (!Objects.equals(userId, String.valueOf(id))) {
            throw new AccessDeniedException("User ID: " + userId + " does not match ID: " + id);
        }
        UserResponseDto userResponseDto = userService.findById(id).orElseThrow();
        return ResponseEntity.ok(userResponseDto);
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<UserResponseDto> findById(@PathVariable Integer id) {
//        UserResponseDto userResponseDto = userService.findById(id).orElseThrow();
//        return ResponseEntity.ok(userResponseDto);
//    }

//    @GetMapping("/{email}")
//    public ResponseEntity<UserResponseDto> findByEmail(@PathVariable String email) {
//        UserResponseDto userResponseDto = userService.findByEmail(email).orElseThrow();
//        return ResponseEntity.ok(userResponseDto);
//    }
}
