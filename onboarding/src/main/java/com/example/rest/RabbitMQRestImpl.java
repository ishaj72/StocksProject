package com.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modules.OnboardInfo;
import com.example.rest.interfaces.IRabbitMQRest;
import com.example.service.rabbitMQ.RabbitMQProducer;

@RestController  
@RequestMapping("/api/rabbitmq")
public class RabbitMQRestImpl implements IRabbitMQRest {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQRestImpl.class);

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    @Override
    public ResponseEntity<String> sendUserInfo(@RequestBody OnboardInfo onboardInfo) {
        log.info("Received request to send user info: {}", onboardInfo);
        
        try {
            rabbitMQProducer.sendUserInfo(onboardInfo);
            return ResponseEntity.ok("User info sent successfully to RabbitMQ");
        } catch (Exception e) {
            log.error("Error sending user info: {}", e.getMessage());
            return ResponseEntity.status(500).body("Failed to send user info");
        }
    }

    @Override
    public ResponseEntity<String> sendUserInfoParams(
            @RequestParam String onboardName, 
            @RequestParam String userId) {
        
        log.info("Received request to send user: onboardName={}, userId={}", onboardName, userId);
        
        try {
            rabbitMQProducer.sendUserInfo(onboardName, userId);
            return ResponseEntity.ok("User info sent successfully to RabbitMQ");
        } catch (Exception e) {
            log.error("Error sending user info: {}", e.getMessage());
            return ResponseEntity.status(500).body("Failed to send user info");
        }
    }
}
