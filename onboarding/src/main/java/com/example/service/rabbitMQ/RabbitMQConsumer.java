package com.example.service.rabbitMQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.interfaces.IOnboardInfoDao;
import com.example.modules.OnboardInfo;
import com.example.service.interfaces.IOnboardingInfoService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RabbitMQConsumer {
    private static final Logger log = (Logger) LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Autowired
    private IOnboardingInfoService onboardingInfoService;

    @RabbitListener(queues = "otp-notification-queue")
    public void receiveOtpNotification(OnboardInfo onboardData) {
        log.info("========================================");
        log.info("📩 Data Received!");
        log.info("UserId: {}", onboardData.getUserId());
        log.info("Role: {}", onboardData.getRole());
        log.info("Onboard Email: {}", onboardData.getOnboardEmail());
        log.info("Pan ID: {}", onboardData.getPanId());
        log.info("Received at: {}", java.time.LocalDateTime.now());
        log.info("========================================");
        
        // Process the OTP notification
        processOtpNotification(onboardData);
        log.info("-------data saving in process------");
        onboardingInfoService.saveOnboardingInfo(onboardData);
        log.info("----data saved---------");
    }
    
    private void processOtpNotification(OnboardInfo onboardData) {
        try {
        
            log.info(" Data processed successfully for: {}", onboardData.getOnboardEmail());
            
        } catch (Exception e) {
            log.error("Error processing data: {}", e.getMessage());
        }
    }
}
