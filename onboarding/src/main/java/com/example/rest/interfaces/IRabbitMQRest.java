package com.example.rest.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface IRabbitMQRest {

     @PostMapping(path = "api/rabbitmq/send")
     String sendMessage(@RequestParam String message);
}
