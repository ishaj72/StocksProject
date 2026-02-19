package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modules.OnboardInfo;
import com.example.rest.interfaces.IOnboardingInfoRest;
import com.example.service.interfaces.IOnboardingInfoService;

@RestController

public class OnboardingInfoRestImpl implements IOnboardingInfoRest {

    @Autowired
    private IOnboardingInfoService onboardingInfoService;

    @Override
    public void saveOnboardingInfo(OnboardInfo onboardInfo) {
        onboardingInfoService.saveOnboardingInfo(onboardInfo);
    }
}
