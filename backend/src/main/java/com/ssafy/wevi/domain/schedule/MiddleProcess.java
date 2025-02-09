package com.ssafy.wevi.domain.schedule;


import com.ssafy.wevi.domain.MiddleProcessStep;
import com.ssafy.wevi.enums.MiddleProcessStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "middle_processes")
@NoArgsConstructor
public class MiddleProcess extends Schedule{
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MiddleProcessStatus status;

    private String detail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "middle_process_step_id", nullable = false)
    private MiddleProcessStep middleProcessStep;
}
