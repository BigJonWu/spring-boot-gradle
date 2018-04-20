package com.example.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(String sendMsg) {
        this.rabbitTemplate.convertAndSend("helloQueue", sendMsg);
    }
}
