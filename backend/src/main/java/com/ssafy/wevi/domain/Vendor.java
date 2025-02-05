package com.ssafy.wevi.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "vendors")
@Getter
@Setter
@NoArgsConstructor
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer vendorId;   // 업체 ID

    @Column(unique = true, nullable = false)
    private String email;   // 이메일

    @Column(nullable = false)
    private String password;    // 비밀번호

    @Column(nullable = false)
    private String ownername;   // 대표자명

    @Column(nullable = false)
    private String ownerPhone;  // 대표자 연락처

    @Column(nullable = false)
    private String name;    // 상호명

    @Column(nullable = false)
    private String zonecode;    // 우편번호

    @Column(nullable = false)
    private Integer sidoId; // 시도ID

//    @Column(nullable = false)
    private Integer sigunguId;  //시군구ID

//    @Column(nullable = false)
    private String address; // 세부주소

//    @Column(nullable = false)
    private String phone;   // 업체 연락처

//    @Column(nullable = false)
    private String registrationNumber;  // 사업자등록번호

//    @Column(nullable = false)
    private LocalDateTime createdAt;    // 생성일

//    @Column(nullable = false)
    private LocalDateTime updatedAt;    // 수정일

//    @Column(nullable = false)
    private Integer categoryId; // 카테고리ID

//    @Column(nullable = false)
    private String pictures;    // 업체사진

//    @Column(nullable = false)
    private LocalDateTime businessStartTime; // 영업 시작시간

//    @Column(nullable = false)
    private LocalDateTime businessEndTime;  // 영업 종료시간

//    @Column(nullable = false)
    private String url; // 홈페이지 URL

    /**
     * 옵션별 가격 : String
     * {옵션명|가격|옵션명|가격|...}
     * 띄어쓰기 X, 가격은 세자리마다 쉼표(,)
     */
//    @Column(nullable = false)
    private String price;   // 옵션별 가격

//    @Column(nullable = false)
    private String details; // 상세설명

//    @Column(nullable = false)
    private boolean isIndoor;   // 실내/야외 여부

//    @Column(nullable = false)
    private int min_price;  // 최소가격

//    // 양방향 연결
//    @OneToMany(mappedBy = "vendor")
//    private List<Schedule> schedules;
}
