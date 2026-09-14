package com.example.dao;

import com.fasterxml.jackson.databind.util.ExceptionUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.stereotype.Repository;

import com.example.constants.Constants;
import com.example.dao.interfaces.IOnboardInfoDao;
import com.example.modules.OnboardInfo;

import java.util.List;

import static com.example.constants.Constants.ERROR_FETCHING_LIST;
import static com.example.constants.Constants.GET_ONBOARD_LIST;

@Repository
@Slf4j
public class OnboardInfoDaoImpl implements IOnboardInfoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    
    public OnboardInfo getOnboardInfoByUserId(String userId) {
        try {
        return entityManager
            .createNamedQuery(Constants.GET_ONBOARD_INFO_BY_USER_ID, OnboardInfo.class)
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

    @Override
    public List<OnboardInfo> getOnboardList(){
        log.info("Inside @Class OnboardInfoDaoImpl @Method getOnboardList");
        try{
            return (List<OnboardInfo>) entityManager.createNamedQuery(GET_ONBOARD_LIST).getResultList();
        }
        catch (Exception ex){
            log.error("Error occurred inside @Method getOnboardList : {}",ex );
            throw new RuntimeException(ERROR_FETCHING_LIST);
        }
    }
}