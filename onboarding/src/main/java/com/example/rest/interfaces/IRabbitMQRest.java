package com.example.rest.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.modules.OnboardInfo;

@RestController
public interface IRabbitMQRest {

      @PostMapping("/send/user")
    ResponseEntity<String> sendUserInfo(@RequestBody OnboardInfo onboardInfo);

    @PostMapping("/send")
    ResponseEntity<String> sendUserInfoParams(
        @RequestParam String onboardName, 
        @RequestParam String userId
    );
}
