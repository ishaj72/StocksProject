package com.example.rest.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.*;

import com.example.modules.OnboardInfo;

import java.util.List;

@RequestMapping("/api/v1/onboard")
public interface IOnboardingInfoRest{

    @PostMapping("/saveOnboardingInfo")
    void saveOnboardingInfo(@RequestBody OnboardInfo onboardInfo);

    @GetMapping("/getOnboardList")
    List<OnboardInfo> getOnboardList();

    @GetMapping("/getOnboardByUserId")
    OnboardInfo getOnboardByUserId(@RequestParam String userId);
}
