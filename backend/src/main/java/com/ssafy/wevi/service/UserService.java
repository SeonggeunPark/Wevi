package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.User;
import com.ssafy.wevi.dto.UserCreateDto;
import com.ssafy.wevi.dto.UserResponseDto;
import com.ssafy.wevi.enums.UserStatus;
import com.ssafy.wevi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserResponseDto create(UserCreateDto userCreateDto) {
        User user = new User();
        user.setEmail(userCreateDto.getEmail());
        user.setNickname(userCreateDto.getNickname());
        user.setName(userCreateDto.getName());
        user.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        user.setPhone(userCreateDto.getPhone());
        user.setAddress(userCreateDto.getAddress());
        user.setStatus(UserStatus.ACTIVE.name());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        return toUserResponseDto(user);
    }

    @Transactional(readOnly = true)
    public Optional<UserResponseDto> findById(Integer id) {
        return userRepository.findById(id).map(user -> toUserResponseDto(user));
    }

//    @Transactional(readOnly = true)
//    public Optional<UserResponseDto> findByEmail(String email) {
//        return userRepository.findByEmail(email).map(user -> toUserResponseDto(user));
//    }

    // update랑 delete도 만들기!!!!!!!!!!!!!!!!

    // 내가 원하는 값만 내보내기 위해서
    // 예를 들어, 유저 정보를 조회할 때 굳이 계약까지 불러올 필요는 없음
    // 유저 -> 계약 -> 유저 무한루프 발생을 막음
    private UserResponseDto toUserResponseDto(User user) {
        if (user == null) return null;

        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setAuthProvider(user.getAuthProvider());
        userResponseDto.setNickname(user.getNickname());
        userResponseDto.setName(user.getName());
        userResponseDto.setPhone(user.getPhone());
        userResponseDto.setAddress(user.getAddress());
        userResponseDto.setCreatedAt(user.getCreatedAt());

        return userResponseDto;
    }
}
