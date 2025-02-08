package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.Customer;
import com.ssafy.wevi.domain.Do;
import com.ssafy.wevi.domain.Sigungu;
import com.ssafy.wevi.domain.SigunguId;
import com.ssafy.wevi.domain.Vendor;
import com.ssafy.wevi.dto.vendor.VendorCreateDto;
import com.ssafy.wevi.dto.vendor.VendorDetailResponseDto;
import com.ssafy.wevi.dto.vendor.VendorResponseDto;
import com.ssafy.wevi.enums.UserStatus;
import com.ssafy.wevi.repository.DoRepository;
import com.ssafy.wevi.repository.SigunguRepository;
import com.ssafy.wevi.repository.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VendorService {

    private final VendorRepository vendorRepository;
    private final DoRepository doRepository;
    private final SigunguRepository sigunguRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public VendorDetailResponseDto createVendor(VendorCreateDto vendorCreateDto) {
        Do doCode = doRepository.findById(vendorCreateDto.getDoCode())
                .orElseThrow(() -> new IllegalArgumentException("해당 도 코드가 존재하지 않습니다."));

        SigunguId sigunguId = new SigunguId(
                vendorCreateDto.getDoCode(),
                vendorCreateDto.getSigunguCode()
        );
        Sigungu sigungu = sigunguRepository.findById(sigunguId)
                .orElseThrow(() -> new IllegalArgumentException("해당 시군구 코드가 존재하지 않습니다."));

        Vendor vendor = new Vendor();
        vendor.setPassword(passwordEncoder.encode(vendorCreateDto.getPassword()));
        vendor.setDoCode(doCode);
        vendor.setSigunguCode(sigungu);
        vendor.setOwnerName(vendorCreateDto.getOwnerName());
        vendor.setOwnerPhone(vendorCreateDto.getOwnerPhone());
        vendor.setName(vendorCreateDto.getName());
        vendor.setZonecode(vendorCreateDto.getZonecode());
        vendor.setAutoRoadAddress(vendorCreateDto.getAutoRoadAddress());
        vendor.setAddressDetail(vendorCreateDto.getAddressDetail());
        vendor.setPhone(vendorCreateDto.getPhone());
        vendor.setRegistrationNumber(vendorCreateDto.getRegistrationNumber());
        vendor.setBusinessHour(vendorCreateDto.getBusinessHour());
        vendor.setHomepage(vendorCreateDto.getHomepage());
        vendor.setPrice(vendorCreateDto.getPrice());
        vendor.setDetails(vendorCreateDto.getDetails());
        vendor.setIndoor(vendorCreateDto.isIndoor());
        vendor.setMinPrice(vendorCreateDto.getMinPrice());
        vendor.setSubway(vendorCreateDto.getSubway());
        vendor.setParkinglot(vendorCreateDto.getParkinglot());
        vendor.setStatus(UserStatus.ACTIVE.name());
        vendor.setCreatedAt(LocalDateTime.now());

        vendorRepository.save(vendor);

        return toVendorResponseDto(vendor);
    }

    private VendorDetailResponseDto toVendorResponseDto(Vendor vendor) {
        if (vendor == null) return null;

        VendorDetailResponseDto vendorDetailResponseDto = new VendorDetailResponseDto();
        vendorDetailResponseDto.setOwnerName(vendor.getOwnerName());
        vendorDetailResponseDto.setOwnerPhone(vendor.getOwnerPhone());
        vendorDetailResponseDto.setName(vendor.getName());
        vendorDetailResponseDto.setZonecode(vendor.getZonecode());
        vendorDetailResponseDto.setAutoRoadAddress(vendor.getAutoRoadAddress());
        vendorDetailResponseDto.setAddressDetail(vendor.getAddressDetail());
        vendorDetailResponseDto.setPhone(vendor.getPhone());
        vendorDetailResponseDto.setRegistrationNumber(vendor.getRegistrationNumber());
        vendorDetailResponseDto.setBusinessHour(vendor.getBusinessHour());
        vendorDetailResponseDto.setHomepage(vendor.getHomepage());
        vendorDetailResponseDto.setPrice(vendor.getPrice());
        vendorDetailResponseDto.setDetails(vendor.getDetails());
        vendorDetailResponseDto.setIndoor(vendor.isIndoor());
        vendorDetailResponseDto.setMinPrice(vendor.getMinPrice());
        vendorDetailResponseDto.setSubway(vendor.getSubway());
        vendorDetailResponseDto.setParkinglot(vendor.getParkinglot());

        return vendorDetailResponseDto;
    }
}