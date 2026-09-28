package com.example.service;

import com.example.dao.interfaces.IAddressInfoDao;
import com.example.modules.AddressInfo;
import com.example.service.interfaces.IAddressInfoService;
import com.fasterxml.jackson.databind.util.ExceptionUtil;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.constants.Constants.SOMETHING_WENT_WRONG;

@Service
@Slf4j
public class AddressInfoServiceImpl implements IAddressInfoService {

    @Autowired
    IAddressInfoDao addressInfoDao;

    @Autowired
    EntityManager entityManager;

    @Override
    public String saveAddressInfo(AddressInfo addressInfo){
        log.info("Inside @Class AddressInfoServiceImpl @Method saveAddressInfo");
        return addressInfoDao.saveAddressInfo(addressInfo);
    }

    @Override
    public String deleteAddressByUserId(String userId){
        log.info("Inside @Class AddressInfoServiceImpl @Method deleteAddressByUserId");
        return addressInfoDao.deleteAddressByUserId(userId);
    }
}
