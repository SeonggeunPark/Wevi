package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.schedule.*;
import com.ssafy.wevi.dto.schedule.*;
import com.ssafy.wevi.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    //==========조회=========//

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
    // 중간과정 단건 조회
    @Transactional(readOnly = true)
    public MiddleProcessDto findMiddleProcessById(Integer id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow();

        if (schedule instanceof MiddleProcess) {
            return toMiddleProcessDto((MiddleProcess) schedule);
        } else {
            throw new IllegalArgumentException("해당 ID는 중간과정 일정이 아닙니다.");
        }
    }
    // 수기등록 일정 단건 조회
    @Transactional(readOnly = true)
    public OtherScheduleDto findOtherScheduleById(Integer id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow();

        if (schedule instanceof OtherSchedule) {
            return toOtherScheduleDto((OtherSchedule) schedule);
        } else {
            throw new IllegalArgumentException("해당 ID는 수기등록 일정이 아닙니다.");
        }
    }
    // 일정 전체 조회
    @Transactional(readOnly = true)
    public List<CommonScheduleDto> findAllSchedules(Integer id) {
        List<Schedule> scheduleList = scheduleRepository.findAllScheduleByCustomerId(id);
        if (scheduleList.size() > 0) {
            return toCommonScheduleList(scheduleList);
        } else {
            throw new IllegalArgumentException("해당하는 일정이 없습니다.");
        }
    }

    private List<CommonScheduleDto> toCommonScheduleList(List<Schedule> scheduleList) {
        List<CommonScheduleDto> commonSchedulelist = new ArrayList<>();

        for (int i=0; i<scheduleList.size(); i++) {
            commonSchedulelist.add(toCommonScheduleDto(scheduleList.get(i)));
        }

        return commonSchedulelist;
    }

    private CommonScheduleDto toCommonScheduleDto(Schedule schedule) {
        CommonScheduleDto commonScheduleDto = new CommonScheduleDto();

        commonScheduleDto.setId(schedule.getId());
        commonScheduleDto.setStartTime(schedule.getStartTime());
        commonScheduleDto.setEndTime(schedule.getEndTime());
        commonScheduleDto.setTitle(schedule.getTitle());
        commonScheduleDto.setCreatedAt(schedule.getCreatedAt());
        commonScheduleDto.setUpdatedAt(schedule.getUpdatedAt());

        return commonScheduleDto;
    }

    private OtherScheduleDto toOtherScheduleDto(OtherSchedule schedule) {
        OtherScheduleDto otherScheduleDto = new OtherScheduleDto();

        otherScheduleDto.setId(schedule.getId());
        otherScheduleDto.setStartTime(schedule.getStartTime());
        otherScheduleDto.setEndTime(schedule.getEndTime());
        otherScheduleDto.setTitle(schedule.getTitle());
        otherScheduleDto.setCreatedAt(schedule.getCreatedAt());
        otherScheduleDto.setUpdatedAt(schedule.getUpdatedAt());
        otherScheduleDto.setCustomerName(schedule.getCustomer().getName());
        otherScheduleDto.setCustomerId(schedule.getCustomer().getUserId());
        otherScheduleDto.setDetail(schedule.getDetail());

        return otherScheduleDto;
    }

    private MiddleProcessDto toMiddleProcessDto(MiddleProcess schedule) {
        MiddleProcessDto middleProcessDto = new MiddleProcessDto();

        middleProcessDto.setId(schedule.getId());
        middleProcessDto.setStartTime(schedule.getStartTime());
        middleProcessDto.setEndTime(schedule.getEndTime());
        middleProcessDto.setTitle(schedule.getTitle());
        middleProcessDto.setCreatedAt(schedule.getCreatedAt());
        middleProcessDto.setUpdatedAt(schedule.getUpdatedAt());
        middleProcessDto.setCustomerName(schedule.getCustomer().getName());
        middleProcessDto.setCustomerId(schedule.getCustomer().getUserId());
        middleProcessDto.setCustomerPhone(schedule.getCustomer().getPhone());
        middleProcessDto.setVendorId(schedule.getVendor().getUserId());
        middleProcessDto.setVendorName(schedule.getVendor().getName());
        middleProcessDto.setVendorAutoRoadAddress(schedule.getVendor().getAutoRoadAddress());
        middleProcessDto.setVendorPhone(schedule.getVendor().getPhone());
        middleProcessDto.setDetail(schedule.getDetail());
        middleProcessDto.setStepName(schedule.getMiddleProcessStep().getName());
        middleProcessDto.setStatus(schedule.getStatus());

        return middleProcessDto;
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
