package com.ssafy.wevi.controller;

import com.ssafy.wevi.config.SecurityUtils;
import com.ssafy.wevi.domain.CoupleRequest;
import com.ssafy.wevi.dto.ApiResponseDto;
import com.ssafy.wevi.service.CoupleRequestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/couple-requests")
@RequiredArgsConstructor
@Slf4j
public class CoupleRequestController {

    private final CoupleRequestService coupleRequestService;

    // 커플 요청 보내기
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponseDto<CoupleRequest> createCoupleRequest(@RequestBody String spouseEmail) {
        String customerId = SecurityUtils.getAuthenticatedUserId();

        CoupleRequest coupleRequestResponse = coupleRequestService.createCoupleRequest(Integer.valueOf(customerId), spouseEmail);

        return new ApiResponseDto<>(
                HttpStatus.CREATED.value(),
                true,
                "CoupleRequest created successfully.",
                coupleRequestResponse
        );
    }

}
