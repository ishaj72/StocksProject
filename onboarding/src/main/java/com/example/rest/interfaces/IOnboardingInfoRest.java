package com.example.rest.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.modules.OnboardInfo;
@RestController
public interface IOnboardingInfoRest {

    @PostMapping(path = "/api/v1/onboard/saveOnboardingInfo")
    public void saveOnboardingInfo(@RequestBody OnboardInfo wrapper);

}
