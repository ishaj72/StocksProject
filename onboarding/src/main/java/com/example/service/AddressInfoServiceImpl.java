package com.example.service;

import com.example.dao.interfaces.IAddressInfoDao;
import com.example.modules.AddressInfo;
import com.example.service.interfaces.IAddressInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AddressInfoServiceImpl implements IAddressInfoService {

    @Autowired
    IAddressInfoDao addressInfoDao;

    @Override
    public String saveAddressInfo(AddressInfo addressInfo){
        log.info("Inside @Class AddressInfoServiceImpl @Method saveAddressInfo");
        return addressInfoDao.saveAddressInfo(addressInfo);
    }
}
