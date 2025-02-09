package com.ssafy.wevi.dto.vendor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VendorResponseDto {
    private String name;
    private Integer doCode;
    private Integer sigunguCode;
    private Integer category;
    private int minPrice;
}