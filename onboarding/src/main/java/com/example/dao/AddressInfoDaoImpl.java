package com.example.dao;

import com.example.dao.interfaces.IAddressInfoDao;
import com.example.modules.AddressInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import static com.example.constants.Constants.DATA_NOT_SAVED;
import static com.example.constants.Constants.DATA_SAVED_SUCCESSFULLY;

@Repository
@Slf4j
public class AddressInfoDaoImpl implements IAddressInfoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AddressInfo getAddressInfoById(){
        return null;
    }

    @Override
    public String saveAddressInfo(AddressInfo addressInfo){
        log.info("Inside @Class AddressInfoServiceImpl @Method saveAddressInfo");
        try{
            entityManager.persist(addressInfo);
            return DATA_SAVED_SUCCESSFULLY;
        }
        catch (Exception ex){
            log.error("Error occurred inside @Method saveAddressInfo : {}", (Object) ex.getStackTrace());
            return DATA_NOT_SAVED;
        }
    }
}
