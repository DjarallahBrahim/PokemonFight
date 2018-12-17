package com.ifi.tp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

public class NotificationServiceImpl implements NotificationService {
    private JmsTemplate jmsTemplate;

    @Autowired
    public NotificationServiceImpl(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void sendNotification(String message) {
        this.jmsTemplate.convertAndSend("notification",message);
    }

}
