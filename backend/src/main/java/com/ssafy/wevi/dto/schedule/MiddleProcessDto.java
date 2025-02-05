package com.ssafy.wevi.dto.schedule;

import com.ssafy.wevi.enums.MiddleProcessStatus;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MiddleProcessDto extends ScheduleDto{
    @Column(name = "middle_process_id", nullable = false)
    private Long id;
    private MiddleProcessStatus status;
    private String detail;
}
