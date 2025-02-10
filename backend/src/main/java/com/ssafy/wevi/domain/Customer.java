package com.ssafy.wevi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("customer")
//@PrimaryKeyJoinColumn(name = "customer_id")
public class Customer extends User {
//    @Id
//    @Column(name = "user_id")
//    private Integer userId;
//
//    @OneToOne
//    @MapsId
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column(unique = true, nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String zonecode;

    @Column(nullable = false)
    private String autoRoadAddress;

    @Column(nullable = false)
    private String addressDetail;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spouse_id")   // 사실 이거 안써도 똑같음
    private Customer spouse;
}
