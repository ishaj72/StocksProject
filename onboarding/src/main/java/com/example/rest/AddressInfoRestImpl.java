package com.example.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.interfaces.IOnboardInfoDao;
import com.example.modules.OnboardInfo;
import com.example.rest.interfaces.IAddressInfoRest;

@RestController
public class AddressInfoRestImpl implements IAddressInfoRest{

    private static final Logger log = LoggerFactory.getLogger(AddressInfoRestImpl.class);

    @Autowired
    IOnboardInfoDao onboardInfoDao;

    @Override
    public void saveAddressInfo(String userId){
        log.info("Inside @Class AddressInfoRestImpl @method saveAddressInfo");
        OnboardInfo onboard = onboardInfoDao.getOnboardInfoByUserId(userId);
        log.info("onboard info for address pk :{}",onboard);
        Integer addressId = onboard.getAddress_fk().getId();
        
    }
}
