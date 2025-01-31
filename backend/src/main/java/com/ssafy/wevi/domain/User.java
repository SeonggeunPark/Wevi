package com.ssafy.wevi.domain;

import com.ssafy.wevi.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// JPA가 Entity에는 Getter, Setter, NoArgs 붙이라고 규칙을 정함.
@Entity
@Table(name = "user")  // 안붙이면 소문자 + snake_case. 이 경우에는 안써도 똑같음
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true, nullable = false)
    String email;

    @Column(unique = true)
    String authId;

    @Column
    String authProvider;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private LocalDateTime createdAt;



}
