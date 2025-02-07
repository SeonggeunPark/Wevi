package com.ssafy.wevi.service;

import com.ssafy.wevi.enums.UserStatus;
import com.ssafy.wevi.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final CustomerRepository customerRepository;

    @Override
    // username으로 이메일이 들어옴
    // 내가 만든 User 아니고 SpringSecurity User임...
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository.findByEmail(username)
                .filter(user -> !UserStatus.TERMINATED.name().equals(user.getStatus()))
                .map(user -> User.builder()
                .username(String.valueOf(user.getUserId())) // Authentication.getName
                .password(user.getPassword())
                .authorities(List.of())
                .build()).orElseThrow(() -> new UsernameNotFoundException("User not found or deactivated: " + username));
    }
}
