package com.example.basic.repository;

import com.example.basic.code.MessageType;
import com.example.basic.code.UserRole;
import com.example.basic.entity.Notification;
import com.example.basic.entity.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class NotificationRepositoryTest {


    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @BeforeEach
    void setUp() {
    }

    @DisplayName("알람 등록 ")
    @Test
    void saveNotification() {
        User user = userRepository.findAll().get(0);

        Notification notification = new Notification();
        notification.setMessage("TEST MESSAGE");
        notification.setUser(user);
        notification.setMessageType(MessageType.OFFER);

        notification.setReadOrNot(false);
        notification.setReceiverId(user.getId());
        notificationRepository.save(notification);

        notificationRepository.findAll().get(0);
        Assertions.assertThat(notification.getId()).isEqualTo(notificationRepository.findAll().get(0).getId());

    }
}