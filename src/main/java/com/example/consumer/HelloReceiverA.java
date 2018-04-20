package com.example.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "helloQueue")
public class HelloReceiverA {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver A: " + msg);
    }
}
