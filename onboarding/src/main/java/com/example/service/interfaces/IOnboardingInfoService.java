package com.example.service.interfaces;

import org.springframework.stereotype.Service;
import com.example.modules.OnboardInfo;

@Service
public interface IOnboardingInfoService {

    public void saveOnboardingInfo(OnboardInfo wrapper);
}
