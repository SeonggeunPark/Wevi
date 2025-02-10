package com.ssafy.wevi.service;

import com.ssafy.wevi.domain.User;
import com.ssafy.wevi.domain.schedule.Schedule;
import com.ssafy.wevi.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {
    private final NotificationRepository notificationRepository;
    private final FirebaseCloudMessagingService firebaseCloudMessagingService;

    public void createScheduleNotification(User receiver, String message, Schedule schedule) {
        Notification notification = Notification.builder()
                .receiver(receiver)
                .message(message)
                .type("SCHEDULE_REMINDER")
                .schedule(schedule)
                .isRead(false)
                .createdAt(LocalDateTime.now())
                .build();

        notificationRepository.save(notification);

        if (receiver.getFcmToken() != null) {
            firebaseMessagingService.sendPushNotification(receiver.getFcmToken(), "📅 일정 알림", message);
        }
    }
}
