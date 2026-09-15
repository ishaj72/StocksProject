package com.example.rest;

import com.example.modules.AddressInfo;
import com.example.service.interfaces.IAddressInfoService;
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
    IAddressInfoService addressInfoService;

    @Override
    public String saveAddressInfo(AddressInfo addressInfo) {
        log.info("Inside @Class AddressInfoRestImpl @method saveAddressInfo");
        return addressInfoService.saveAddressInfo(addressInfo);
    }
}
