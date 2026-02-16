package com.example.service.rabbitMQ;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onboarding.config.RabbitMQConfig;

@Service
public class RabbitMQProducer {
    // @Autowired
    // private RabbitTemplate rabbitTemplate;

    // public void sendMessage(String message) {
    //     rabbitTemplate.convertAndSend(
    //         RabbitMQConfig.EXCHANGE_NAME,
    //         RabbitMQConfig.ROUTING_KEY,
    //         message
    //     );
    //     System.out.println("Message sent: " + message);
    // }

    // // For sending objects as JSON
    // public void sendObject(Object object) {
    //     rabbitTemplate.convertAndSend(
    //         RabbitMQConfig.EXCHANGE_NAME,
    //         RabbitMQConfig.ROUTING_KEY,
    //         object
    //     );
    //     System.out.println("Object sent: " + object);
    // }
}
