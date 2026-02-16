package com.example.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.example.modules.OnboardInfo;

@Service
public interface IOnboardingInfoService extends JpaRepository<OnboardInfo, Long> {

    public void saveOnboardingInfo(OnboardInfo wrapper);
}
