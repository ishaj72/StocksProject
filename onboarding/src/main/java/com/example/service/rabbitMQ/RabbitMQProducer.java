package com.example.service.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.constants.Constants;
import com.example.modules.OnboardInfo;
import com.example.onboarding.config.RabbitMQConfig;

@Service
public class RabbitMQProducer {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

     public <T> void sendMessage(String exchange, String routingKey, T message) {

        log.info("Sending message to exchange={}, routingKey={}, payload={}",
                 exchange, routingKey, message);

        rabbitTemplate.convertAndSend(exchange, routingKey, message);

        log.info("✅ Message sent successfully");
    }

}
