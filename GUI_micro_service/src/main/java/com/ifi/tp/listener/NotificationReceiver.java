package com.ifi.tp.listener;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class NotificationReceiver {

    private  String message="";
    @JmsListener(destination="notification")
    public void receiveNotification(String notification){
        this.message = notification;
        System.out.println(notification);

    }

    public String getMessage() {
        return this.message;
    }
}
