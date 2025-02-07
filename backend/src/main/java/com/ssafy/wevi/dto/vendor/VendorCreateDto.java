package com.ssafy.wevi.dto.vendor;

import com.ssafy.wevi.domain.Do;
import com.ssafy.wevi.domain.Sigungu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorCreateDto {
    private String ownerName;
    private String ownerPhone;
    private String name;
    private String zonecode;
    private Do doCode;
    private Sigungu sigunguCode;
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
    private int subway;
    private int parkinglot;
}