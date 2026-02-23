package com.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.constants.Constants;
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
    public ResponseEntity<String> sendUserInfo(OnboardInfo onboardInfo) {

        log.info("Received request: {}", onboardInfo);

        rabbitMQProducer.sendMessage(
            Constants.PRODUCER_EXCHANGE_NAME,
            Constants.PRODUCER_ROUTING_KEY,
            onboardInfo
        );

        return ResponseEntity.ok("User info sent successfully");
    }
}
