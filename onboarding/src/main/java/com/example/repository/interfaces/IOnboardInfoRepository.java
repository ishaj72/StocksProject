package com.example.repository.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modules.OnboardInfo;

@Repository
public interface IOnboardInfoRepository extends JpaRepository<OnboardInfo, String> {

    OnboardInfo getOnboardInfoByUserId(String userId);
}
