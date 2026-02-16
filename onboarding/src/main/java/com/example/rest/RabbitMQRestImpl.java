package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest.interfaces.IRabbitMQRest;
import com.example.service.rabbitMQ.RabbitMQProducer;

@RestController  
public class RabbitMQRestImpl implements IRabbitMQRest {

    @Autowired
    private RabbitMQProducer producer;

    @Override
    public String sendMessage(@RequestParam String message) {
        producer.sendMessage(message);
        return "Message sent to RabbitMQ: " + message;
    }
}
