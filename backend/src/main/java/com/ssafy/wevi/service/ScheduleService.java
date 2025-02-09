package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.schedule.Consultation;
import com.ssafy.wevi.domain.schedule.Contract;
import com.ssafy.wevi.domain.schedule.Schedule;
import com.ssafy.wevi.dto.schedule.ConsultationDto;
import com.ssafy.wevi.dto.schedule.ContractDto;
import com.ssafy.wevi.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 상담 단건 조회
    @Transactional(readOnly = true)
    public ConsultationDto findConsultationById(Integer id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow();

        if (schedule instanceof Consultation) {
            return toConsultationDto((Consultation) schedule);
        } else {
            throw new IllegalArgumentException("해당 ID는 상담 일정이 아닙니다.");
        }
    }
    // 계약 단건 조회
    @Transactional(readOnly = true)
    public ContractDto findContractById(Integer id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow();

        if (schedule instanceof Contract) {
            return toContractDto((Contract) schedule);
        } else {
            throw new IllegalArgumentException("해당 ID는 계약 일정이 아닙니다.");
        }
    }

    private ContractDto toContractDto(Contract schedule) {
        ContractDto contractDto = new ContractDto();

        contractDto.setId(schedule.getId());
        contractDto.setStartTime(schedule.getStartTime());
        contractDto.setEndTime(schedule.getEndTime());
        contractDto.setTitle(schedule.getTitle());
        contractDto.setCreatedAt(schedule.getCreatedAt());
        contractDto.setUpdatedAt(schedule.getUpdatedAt());
        contractDto.setCustomerId(schedule.getCustomer().getUserId());
        contractDto.setCustomerName(schedule.getCustomer().getName());
        contractDto.setCustomerPhone(schedule.getCustomer().getPhone());
        contractDto.setVendorId(schedule.getVendor().getUserId());
        contractDto.setVendorName(schedule.getVendor().getName());
        contractDto.setVendorAutoRoadAddress(schedule.getVendor().getAutoRoadAddress());
        contractDto.setVendorPhone(schedule.getVendor().getPhone());
        contractDto.setPrice(schedule.getPrice());
        contractDto.setContractDate(schedule.getContractDate());
        contractDto.setDetail(schedule.getDetail());

        return contractDto;
    }

    private ConsultationDto toConsultationDto(Consultation consultation) {
        ConsultationDto consultationDto = new ConsultationDto();

        consultationDto.setId(consultation.getId());
        consultationDto.setStartTime(consultation.getStartTime());
        consultationDto.setEndTime(consultation.getEndTime());
        consultationDto.setTitle(consultation.getTitle());
        consultationDto.setCreatedAt(consultation.getCreatedAt());
        consultationDto.setUpdatedAt(consultation.getUpdatedAt());
        consultationDto.setCustomerId(consultation.getCustomer().getUserId());
        consultationDto.setCustomerName(consultation.getCustomer().getName());
        consultationDto.setCustomerPhone(consultation.getCustomer().getPhone());
        consultationDto.setVendorId(consultation.getVendor().getUserId());
        consultationDto.setVendorName(consultation.getVendor().getName());
        consultationDto.setVendorAutoRoadAddress(consultation.getVendor().getAutoRoadAddress());
        consultationDto.setVendorPhone(consultation.getVendor().getPhone());
        consultationDto.setRequest(consultation.getRequest());

        return consultationDto;
    }
}
