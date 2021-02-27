package com.mashsoft.sms.domain;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageReciever {

    @JmsListener(destination = "reciever", containerFactory = "customFactory")
    public void recieveMessage(String message) {
        System.out.println("Message recieved: " + message);
    }

}
