package com.ssafy.wevi.dto.Ai;

import com.ssafy.wevi.dto.schedule.ConsultationResponseDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ConsultationSummaryResponseDto {
    ConsultationResponseDto consultationResponseDto;
    AudioSummaryResponseDto audioSummaryResponseDto;
}
