package com.ssafy.wevi.controller;

import com.ssafy.wevi.dto.ApiResponseDto;
import com.ssafy.wevi.dto.schedule.ConsultationDto;
import com.ssafy.wevi.dto.schedule.ContractDto;
import com.ssafy.wevi.repository.ScheduleRepository;
import com.ssafy.wevi.service.CustomerService;
import com.ssafy.wevi.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleRepository scheduleRepository;
    private final CustomerService customerService;

    //== READ ==//
    // 상담 상세 조회
    @GetMapping("/consultation/{id}")
    public ApiResponseDto<?> getOneConsultation(@PathVariable Integer id) {
        ConsultationDto consultationDto = scheduleService.findConsultationById(id);
        if (consultationDto == null) {
            return new ApiResponseDto<>(
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    "Consultation not found.",
                    null
            );
        }
        return new ApiResponseDto<>(
                HttpStatus.OK.value(),
                true,
                "Consultation found successfully.",
                consultationDto
        );
    }
    // 계약 상세 조회
    @GetMapping("/contract/{id}")
    public ApiResponseDto<?> getOneContract(@PathVariable Integer id) {
        ContractDto contractDto = scheduleService.findContractById(id);
        if (contractDto == null) {
            return new ApiResponseDto<>(
                    HttpStatus.NOT_FOUND.value(),
                    false,
                    "Consultation not found.",
                    null
            );
        }
        return new ApiResponseDto<>(
                HttpStatus.OK.value(),
                true,
                "Consultation found successfully.",
                contractDto
        );
    }

}
