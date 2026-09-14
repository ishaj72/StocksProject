package com.example.dao.interfaces;

import com.example.modules.OnboardInfo;

import java.util.List;

public interface IOnboardInfoDao {
    OnboardInfo getOnboardInfoByUserId(String userId);
    void save(OnboardInfo onboardInfo);
    OnboardInfo update(OnboardInfo onboardInfo);
    List<OnboardInfo> getOnboardList();
}