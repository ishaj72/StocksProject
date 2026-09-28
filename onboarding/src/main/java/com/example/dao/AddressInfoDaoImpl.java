package com.example.dao;

import com.example.dao.interfaces.IAddressInfoDao;
import com.example.modules.AddressInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import java.util.Objects;
import static com.example.constants.Constants.*;

@Repository
@Slf4j
public class AddressInfoDaoImpl implements IAddressInfoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public AddressInfo getAddressInfoByUserId(String userId){
        log.info("Inside @Class AddressInfoDaoImpl @Method getAddressInfoByUserId for userId :{}",userId);
        try {
            return entityManager.createNamedQuery(GET_ADDRESS_INFO_BY_USER_ID, AddressInfo.class)
                    .setParameter("userId", userId)
                    .getSingleResult();
        }
        catch (Exception ex){
            log.error("Error occurred inside @method deleteAddressByUserId : {}",ex.getStackTrace());
            throw new RuntimeException(NO_DATA_FOR_THIS_USER_ID);
        }
    }

    @Transactional
    @Override
    public String saveAddressInfo(AddressInfo addressInfo){
        log.info("Inside @Class AddressInfoDaoImpl @Method saveAddressInfo");
        try{
            entityManager.persist(addressInfo);
            return DATA_SAVED_SUCCESSFULLY;
        }
        catch (Exception ex){
            log.error("Error occurred inside @Method saveAddressInfo : {}", ex);
            return DATA_NOT_SAVED;
        }
    }

    @Transactional
    @Override
    public String deleteAddressByUserId(String userId){
        log.info("Inside @Class AddressInfoDaoImpl @Method deleteAddressByUserId :{}",userId);
        try{
            AddressInfo addressInfo = getAddressInfoByUserId(userId);
            log.info("Address info : {}",addressInfo);
            if(Objects.nonNull(addressInfo)){
                AddressInfo managedEntity = entityManager.merge(addressInfo);
                entityManager.remove(managedEntity);
                return DATA_DELETED_SUCCESSFULLY;
            }
            return DATA_NOT_DELETED;
        }
        catch (Exception ex){
            log.error("Error occurred inside @method deleteAddressByUserId : {}",ex.getStackTrace());
            return SOMETHING_WENT_WRONG;
        }
    }
}
