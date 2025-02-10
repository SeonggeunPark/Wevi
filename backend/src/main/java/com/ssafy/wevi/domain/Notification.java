package com.ssafy.wevi.domain;

import com.ssafy.wevi.domain.schedule.Schedule;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;  // 소비자 or 업체

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Boolean isRead = false;  // 읽음 여부 (기본값: false)

    @Column(nullable = false)
    private String type;  // 알림 타입 (예: "SCHEDULE_REMINDER", "COUPLE_REQUEST")

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;  // 일정 관련 알림이면 연결됨 (필수 아님)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couple_request_id")
    private CoupleRequest coupleRequest;  // 커플 요청 관련 알림이면 연결됨 (필수 아님)
}
