package com.ifi.tp;

import com.ifi.tp.listener.NotificationReceiver;
import org.junit.jupiter.api.Test;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

public class NotificationReceiverTest {
    @Test
    void notificationReceiver_shouldBeAnnotated(){
        var componentAnnotation = NotificationReceiver.class.getAnnotation(Component.class);
        assertNotNull(componentAnnotation);
    }

    @Test
    void receiveNotification_shouldBeAnnotated() throws NoSuchMethodException {
        var receiveNotificationMethod = NotificationReceiver.class.getDeclaredMethod("receiveNotification", String.class);
        var jmsListenerAnnotation = receiveNotificationMethod.getAnnotation(JmsListener.class);
        assertNotNull(jmsListenerAnnotation);
        assertEquals("notification", jmsListenerAnnotation.destination());
    }
}
