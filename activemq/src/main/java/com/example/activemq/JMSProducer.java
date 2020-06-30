package com.example.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @author merz
 * @Description:
 * @date 2018/10/24 10:50
 */
@Component
public class JMSProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }
}