package com.example.service;
import org.apache.tomcat.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import com.example.constants.Constants;
import com.example.dao.interfaces.IOnboardInfoDao;
import com.example.modules.AddressInfo;
import com.example.modules.OnboardInfo;
import com.example.service.interfaces.IOnboardingInfoService;

import jakarta.persistence.EntityManager;

import java.util.List;


@Service
@Transactional
public class OnboardingInfoServiceImpl implements IOnboardingInfoService {

    @Autowired
    private IOnboardInfoDao onboardInfoDao;

    @Autowired
    private EntityManager entityManager;

    private static final Logger log = LoggerFactory.getLogger(OnboardingInfoServiceImpl.class);

    @Override
    public void saveOnboardingInfo(OnboardInfo onboardInfo) {
        log.info("Inside @Class OnboardInfoServiceImpl @method saveOnboardingInfo for : {}",onboardInfo);
        try{
        if (ObjectUtils.isEmpty(onboardInfo)) {
        throw new IllegalArgumentException("OnboardInfo cannot be null");
        }

        OnboardInfo infoExists = onboardInfoDao.getOnboardInfoByUserId(onboardInfo.getUserId());
        log.info("onboard data : {}",infoExists);
        if (infoExists == null) {
            onboardInfoDao.save(onboardInfo);
            log.info("Data saved successfully");
        } 
        else {
          //  OnboardInfo updateOnboardInfo = rabbitMQConsumer.receiveOtpNotification(onboardInfo);
            onboardInfoDao.update(onboardInfo);
            log.info("Data updated successfully");
        }
        }
        catch(Exception ex){
            log.error("Error occurred inside @method saveOnboardingInfo :{}",ex.getMessage());
            throw new RuntimeException(Constants.SOMETHING_WENT_WRONG);
        }
    }

    @Override
    public List<OnboardInfo> getOnboardList(){
        log.info("Inside @Class OnboardingInfoServiceImpl @Method getOnboardList");
        try{
            return onboardInfoDao.getOnboardList();
        }
        catch (Exception ex){
            log.error("Error occurred inside @method getOnboardList : {}", ExceptionUtils.unwrapInvocationTargetException(ex));
            throw new RuntimeException(ex.getMessage());
        }
    }

    @Override
    public OnboardInfo getOnboardByUserId(String userId){
        log.info("Inside @Class OnboardingInfoServiceImpl @Method getOnboardByUserId for userId :{}",userId);
        try{
            return onboardInfoDao.getOnboardInfoByUserId(userId);
        }
        catch (Exception ex){
            log.error("Error occurred inside @Method getOnboardInfoByUseId : {}", (Object) ex.getStackTrace());
            throw new RuntimeException(ex.getMessage());
        }
    }
}
    
