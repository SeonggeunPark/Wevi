package com.ssafy.wevi.dto.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommonScheduleDto {
    // 일정 공통
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
