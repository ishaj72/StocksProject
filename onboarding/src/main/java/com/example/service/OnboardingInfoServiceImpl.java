package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.modules.OnboardInfo;
import com.example.repository.interfaces.IOnboardInfoRepository;
import com.example.service.interfaces.IOnboardingInfoService;

@Service
public class OnboardingInfoServiceImpl implements IOnboardingInfoService {

    @Autowired
    private IOnboardInfoRepository onboardInfoRepository;

    @Override
    @Transactional
    public void saveOnboardingInfo(OnboardInfo onboardInfo) {

        if (ObjectUtils.isEmpty(onboardInfo)) {
            throw new IllegalArgumentException("OnboardInfo cannot be null");
        }

        onboardInfoRepository.save(onboardInfo);
    }
}
