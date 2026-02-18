package com.example.service.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.modules.OnboardInfo;
import com.example.onboarding.config.RabbitMQConfig;

@Service
public class RabbitMQProducer {
    private static final Logger log = LoggerFactory.getLogger(RabbitMQProducer.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * Send OnboardInfo (onboardName and userId) as JSON to RabbitMQ
     */
    public void sendUserInfo(OnboardInfo onboardInfo) {
        log.info("Sending user info to RabbitMQ: {}", onboardInfo);
        
        rabbitTemplate.convertAndSend(
            RabbitMQConfig.PRODUCER_EXCHANGE_NAME,
            RabbitMQConfig.PRODUCER_ROUTING_KEY,
            onboardInfo
        );
        
        log.info("✅ User info sent successfully: onboardName={}, userId={}", 
                 onboardInfo.getOnboardName(), onboardInfo.getUserId());
    }

    /**
     * Convenience method to send onboardName and userId directly
     */
    public void sendUserInfo(String onboardName, String userId) {
        OnboardInfo onboardInfo = new OnboardInfo(onboardName, userId);
        sendUserInfo(onboardInfo);
    }
}
