package com.ssafy.wevi.dto.vendor;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VendorDetailResponseDto {
    private Integer userId;
    private LocalDateTime createdAt;
    private String ownerName;
    private String ownerPhone;
    private String name;
    private String zonecode;
    private String doCode;
    private String sigunguCode;
    private String autoRoadAddress;
    private String addressDetail;
    private String phone;
    private String registrationNumber;
    private String businessHour;
    private String homepage;
    private String price;
    private String details;
    private boolean isIndoor;
    private int minPrice;
    private String subway;
    private String parkinglot;
}
