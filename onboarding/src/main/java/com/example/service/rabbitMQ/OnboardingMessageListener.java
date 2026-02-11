package com.example.service.rabbitMQ;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.example.onboarding.config.RabbitMQConfig;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@Slf4j
public class OnboardingMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(OnboardingMessageListener.class);
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = RabbitMQConfig.ONBOARD_QUEUE)
    public void handleOnboardingMessage(String message) {
        try {
            logger.info("Received message from onboarding queue: {}", message);
            // Optionally, deserialize and process the message here
            logger.info("Message processed successfully");
        } catch (Exception e) {
            logger.error("Error processing onboarding message: {}", message, e);
            throw new RuntimeException("Failed to process message", e);
        }
    }

    @RabbitListener(queues = RabbitMQConfig.ONBOARD_DEAD_LETTER_QUEUE)
    public void handleDeadLetterMessage(String message) {
        logger.error("Message received in dead letter queue: {}", message);
    }
}
