package com.ssafy.wevi.dto.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ConstractDto extends ScheduleDto{
    private int price;  // 계약금액
    private LocalDateTime contractDate; // 계약일
    private String detail;  // 계약 세부사항
}
