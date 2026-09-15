package com.example.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.modules.OnboardInfo;
import com.example.rest.interfaces.IOnboardingInfoRest;
import com.example.service.interfaces.IOnboardingInfoService;

import java.util.List;

@RestController
@Slf4j
public class OnboardingInfoRestImpl implements IOnboardingInfoRest {

    @Autowired
    private IOnboardingInfoService onboardingInfoService;

    @Override
    public void saveOnboardingInfo(OnboardInfo onboardInfo) {
        log.info("Inside @Class OnboardingInfoRestImpl @method saveOnboardingInfo for : {}",onboardInfo);
        onboardingInfoService.saveOnboardingInfo(onboardInfo);
    }

    @Override
    public List<OnboardInfo > getOnboardList(){
        log.info("Inside @Class OnboardingInfoRestImpl @method getOnboardList");
        return onboardingInfoService.getOnboardList();
    }

    @Override
    public OnboardInfo getOnboardByUserId(String userId){
        log.info("Inside @Class OnboardInfoRestImpl @Method getOnboardByUserId for userId : {}",userId);
        return onboardingInfoService.getOnboardByUserId(userId);
    }
}

