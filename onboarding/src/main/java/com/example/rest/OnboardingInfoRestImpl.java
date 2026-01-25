package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.modules.OnboardInfo;
import com.example.rest.interfaces.IOnboardingInfoRest;
import com.example.service.interfaces.IOnboardingInfoService;

public class OnboardingInfoRestImpl implements IOnboardingInfoRest {

    @Autowired
    IOnboardingInfoService onboardingInfoService;


    @Override
    public void saveOnboardingInfo(OnboardInfo wrapper){
        onboardingInfoService.saveOnboardingInfo(wrapper);
    }
    
}
