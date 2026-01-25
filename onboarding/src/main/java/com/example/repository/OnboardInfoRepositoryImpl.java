package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.constants.Constants;
import com.example.modules.OnboardInfo;
import com.example.repository.interfaces.IOnboardInfoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

@Repository
public class OnboardInfoRepositoryImpl implements IOnboardInfoRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OnboardInfo getOnboardInfoByUserId(String userId) {
        try {
            return entityManager
                .createNamedQuery("getOnboardInfoByUserId", OnboardInfo.class)
                .setParameter("userId", userId)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}