package com.example.rest.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.modules.OnboardInfo;

@RequestMapping("/api/v1/onboard")
public interface IOnboardingInfoRest {

    @PostMapping("/saveOnboardingInfo")
    void saveOnboardingInfo(@RequestBody OnboardInfo onboardInfo);
}
