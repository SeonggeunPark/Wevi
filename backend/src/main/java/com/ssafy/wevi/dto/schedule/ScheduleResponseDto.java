package com.ssafy.wevi.dto.schedule;

import java.time.LocalDateTime;

public class ScheduleResponseDto {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
//    private ScheduleStatus status;
}
