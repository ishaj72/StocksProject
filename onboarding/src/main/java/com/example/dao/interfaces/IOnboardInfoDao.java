package com.example.dao.interfaces;

import com.example.modules.OnboardInfo;

public interface IOnboardInfoDao {
    OnboardInfo getOnboardInfoByUserId(String userId);
    void save(OnboardInfo onboardInfo);
    OnboardInfo update(OnboardInfo onboardInfo);
}