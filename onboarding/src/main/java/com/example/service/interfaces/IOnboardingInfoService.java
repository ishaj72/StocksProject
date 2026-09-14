package com.example.service.interfaces;

import com.example.modules.OnboardInfo;

import java.util.List;

public interface IOnboardingInfoService {

    void saveOnboardingInfo(OnboardInfo onboardInfo);

    List<OnboardInfo> getOnboardList();
}
