package com.ssafy.wevi.dto.schedule;

import com.ssafy.wevi.domain.Customer;
import com.ssafy.wevi.domain.Vendor;

import java.time.LocalDateTime;

public class ScheduleDto {
    private int id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String title;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Customer customer;
    private Vendor vendor;
//    private ScheduleStatus status;
}
