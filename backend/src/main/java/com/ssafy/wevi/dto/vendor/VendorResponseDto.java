package com.ssafy.wevi.dto.vendor;

import com.ssafy.wevi.domain.Do;
import com.ssafy.wevi.domain.Sigungu;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorResponseDto {
    private Integer userId;
    private String name;
    private Do doCode;
    private Sigungu sigunguCode;
//    private String category;
    private int minPrice;
}