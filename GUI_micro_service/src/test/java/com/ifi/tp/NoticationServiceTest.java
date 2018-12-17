package com.ifi.tp;

import com.ifi.tp.service.NotificationServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.verify;

public class NoticationServiceTest {
    @InjectMocks
    private NotificationServiceImpl notificationService;

    @Mock
    private JmsTemplate jmsTemplate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void sendNotification_shouldCallTheJmsTemplate(){
        this.notificationService.sendNotification("test");

        verify(jmsTemplate).convertAndSend("notification", "test");
    }
}
