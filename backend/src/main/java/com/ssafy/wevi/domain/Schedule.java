package com.ssafy.wevi.domain;

import com.ssafy.wevi.enums.ScheduleStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Schedule {

    @Id @GeneratedValue
    @Column(name = "shcedule_id")
    private int id; // 스케줄ID

//    @Column(name = "start_time")
    private LocalDateTime startTime;

//    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private ScheduleStatus status;

    private String title;

    private String detail;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

//    private int price;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "vendor_id")
//    private Vendor vendor;
}
