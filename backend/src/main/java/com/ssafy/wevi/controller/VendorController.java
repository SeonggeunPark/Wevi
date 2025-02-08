package com.ssafy.wevi.controller;

import com.ssafy.wevi.dto.ApiResponseDto;
import com.ssafy.wevi.dto.Customer.CustomerCreateDto;
import com.ssafy.wevi.dto.Customer.CustomerResponseDto;
import com.ssafy.wevi.dto.vendor.VendorCreateDto;
import com.ssafy.wevi.dto.vendor.VendorDetailResponseDto;
import com.ssafy.wevi.service.CustomerService;
import com.ssafy.wevi.service.VendorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vendors")
@RequiredArgsConstructor
@Slf4j
public class VendorController {

    private final VendorService vendorService;

    // CREATE는 Optional일 수가 없으므로 Optional 벗길 필요 X
    // 회원가입
    @PostMapping("/signup")
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<VendorDetailResponseDto> createVendor(@RequestBody VendorCreateDto vendorCreateDto) {
        VendorDetailResponseDto vendorDetailResponseDto = vendorService.createVendor(vendorCreateDto);

        return new ApiResponseDto<>(
                HttpStatus.CREATED.value(),
                true,
                "Vendorcreated successfully.",
                vendorDetailResponseDto
        );
    }

    @GetMapping("/dolist")
    public ResponseEntity<List<DoCode>> getAllDoCodes() {

        return ResponseEntity.ok(locationService.getAllDoCodes());
    }

    @GetMapping("/sigungulist/{doCode}")
    public ResponseEntity<List<SigunguCode>> getSigunguByDoCode(@PathVariable Integer doCode) {
        return ResponseEntity.ok(locationService.getSigunguByDoCode(doCode));
    }
}
