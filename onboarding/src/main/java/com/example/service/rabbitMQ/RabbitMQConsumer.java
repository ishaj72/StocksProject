package com.example.service.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.onboarding.config.RabbitMQConfig;

@Service
public class RabbitMQConsumer {
     @RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Message received: " + message);
        // Process your message here
    }
}
