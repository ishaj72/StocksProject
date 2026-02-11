package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.modules.OnboardInfo;
import com.example.service.interfaces.IOnboardingInfoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class OnboardingInfoServiceImpl implements IOnboardingInfoService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveOnboardingInfo(OnboardInfo wrapper) {
        if (wrapper == null) {
            throw new IllegalArgumentException("Wrapper cannot be null");
        }

        // Persist the address first if it exists
        if (wrapper.getAddress_fk() != null && wrapper.getAddress_fk().getId() == null) {
            entityManager.persist(wrapper.getAddress_fk());
        }

        // Persist the onboarding info
        entityManager.persist(wrapper);
    }
}
