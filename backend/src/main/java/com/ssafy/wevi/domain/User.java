package com.ssafy.wevi.domain;

import com.ssafy.wevi.enums.UserStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// JPA가 Entity에는 Getter, Setter, NoArgs 붙이라고 규칙을 정함.
@Entity
@Table(name = "users")  // 안붙이면 소문자 + snake_case. 이 경우에는 안써도 똑같음
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(unique = true)
    private String authId;

    @Column
    private String authProvider;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String zonecode;

    @Column(nullable = false)
    private String autoRoadAddress;

    @Column(nullable = false)
    private String addressDetail;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spouse_id")   // 사실 이거 안써도 똑같음
    private User spouse;
}
