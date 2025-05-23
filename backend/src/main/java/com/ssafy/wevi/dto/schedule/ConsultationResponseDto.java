package com.ssafy.wevi.dto.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConsultationResponseDto {
    private Integer loginUserId;
    // 일정 공통
    private int scheduleId;
//    private LocalDateTime startTime;
//    private LocalDateTime endTime;

    private String startDate;
    private String startTime;
    private String endDate;
    private String endTime;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer categoryId;
    private String categoryName;

    // 상담 별도
    private String request;


    // 객체 직접 참조 X
//    private Customer customer;
//    private Vendor vendor;

    // 소비자 데이터
    private Integer customerId;
    private String customerName;
    private String customerPhone;

    // 업체 데이터
    private Integer vendorId;
    private String vendorName;
    private String vendorAutoRoadAddress;
    private String vendorPhone;
    private String vendorImageUrl;
    
    // 상담 분석 요청 여부 확인용
    private String status;
}
