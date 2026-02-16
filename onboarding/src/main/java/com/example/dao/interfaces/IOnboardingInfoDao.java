package com.example.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.modules.OnboardInfo;

@Repository
public interface IOnboardingInfoDao extends JpaRepository<OnboardInfo, Long>{

    OnboardInfo getOnboardInfoByUserId(String userId) ;
}
