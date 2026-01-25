package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.modules.OnboardInfo;
import com.example.service.interfaces.IOnboardingInfoService;
import jakarta.persistence.EntityManager;

public class OnboardingInfoServiceImpl implements IOnboardingInfoService {
    
    @Autowired
    EntityManager entityManager;

    @Override
    public void saveOnboardingInfo(OnboardInfo wrapper) {
        if(wrapper == null) {
            throw new IllegalArgumentException("Wrapper cannot be null");
        }   
        
        

     
    }
}
