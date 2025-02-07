package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.Vendor;
import com.ssafy.wevi.dto.vendor.VendorDetailResponseDto;
import com.ssafy.wevi.dto.vendor.VendorResponseDto;
import com.ssafy.wevi.repository.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VendorService {
    private final VendorRepository vendorRepository;

    public Page<VendorResponseDto> getAllVendors(Pageable pageable) {
        return vendorRepository.findAllWithDetails(pageable)
                .map(VendorResponseDto::from);
    }

    public VendorDetailResponseDto getVendorDetail(Integer vendorId) {
        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("Vendor not found"));
        return VendorDetailResponseDto.fromEntity(vendor);
    }
}