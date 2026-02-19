package com.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.example.constants.Constants;
import com.example.dao.interfaces.IOnboardInfoDao;
import com.example.modules.OnboardInfo;

@Repository
public class OnboardInfoDaoImpl implements IOnboardInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public OnboardInfo getOnboardInfoByUserId(String userId) {
        try {
            return entityManager.createQuery(Constants.GET_ONBOARD_INFO_BY_USER_ID, OnboardInfo.class)
                .setParameter("userId", userId)
                .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(OnboardInfo onboardInfo) {
        entityManager.persist(onboardInfo);
    }

    @Override
    public OnboardInfo update(OnboardInfo onboardInfo) {
        return entityManager.merge(onboardInfo);
    }
}