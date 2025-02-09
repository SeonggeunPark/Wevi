package com.ssafy.wevi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// JPA가 Entity에는 Getter, Setter, NoArgs 붙이라고 규칙을 정함.
@Entity
@Table(name = "users")  // 안붙이면 소문자 + snake_case. 이 경우에는 안써도 똑같음
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype")
@Getter
@Setter
@NoArgsConstructor
public abstract class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String authId;

    @Column
    private String authProvider;

    @Column(nullable = false)
    private String status;
}