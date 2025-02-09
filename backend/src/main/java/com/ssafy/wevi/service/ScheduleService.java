package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.schedule.Consultation;
import com.ssafy.wevi.domain.schedule.Schedule;
import com.ssafy.wevi.dto.schedule.ConsultationDto;
import com.ssafy.wevi.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional(readOnly = true)
    public ConsultationDto findConsultationById(Integer id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow();

        System.out.println("들어옴");
        if (schedule instanceof Consultation) {
            return toConsultationDto((Consultation) schedule);
        } else {
            throw new IllegalArgumentException("해당 ID는 상담 일정이 아닙니다.");
        }
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
        consultationDto.setVendorId(consultation.getVendor().getUserId());
        consultationDto.setRequest(consultation.getRequest());

        return consultationDto;
    }
}
