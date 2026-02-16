package com.example.service.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.example.modules.UserEvent;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQConsumer {
    private static final Logger log = (Logger) LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "otp-notification-queue")
    public void receiveOtpNotification(UserEvent notification) {
        log.info("========================================");
        log.info("📩 OTP Notification Received!");
        log.info("Email: {}", notification.getEmail());
        log.info("OTP: {}", notification.getOtp());
        log.info("Received at: {}", java.time.LocalDateTime.now());
        log.info("========================================");
        
        // Process the OTP notification
        processOtpNotification(notification);
    }
    
    private void processOtpNotification(UserEvent notification) {
        try {
        
            log.info(" OTP notification processed successfully for: {}", notification.getEmail());
            
        } catch (Exception e) {
            log.error("Error processing OTP notification: {}", e.getMessage());
        }
    }
}
