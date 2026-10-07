package com.example.dao;

import com.example.constants.Constants;
import com.example.dao.interfaces.IDocumentInfoDao;
import com.example.modules.AddressInfo;
import com.example.modules.DocumentInfo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;

import static com.example.constants.Constants.*;

@Repository
@Slf4j
public class DocumentInfoDaoImpl  implements IDocumentInfoDao {

    @Autowired
    EntityManager entityManager;

    @Override
    @Transactional
    public String saveDocumentInfo(DocumentInfo documentInfo){
        log.info("Inside @Class DocumentInfoDaoImpl @Method saveDocumentInfo : {}",documentInfo);
        try{
            if (ObjectUtils.isEmpty(documentInfo)) {
                throw new IllegalArgumentException("documentInfo cannot be null");
            }

            List<DocumentInfo> infoExists = getDocumentInfoByUserId(documentInfo.getUserId());
            log.info("documet data : {}",infoExists);
            if (infoExists == null) {
                save(documentInfo);
                log.info("Data saved successfully");
                return DATA_SAVED_SUCCESSFULLY;
            }
            else {
                DocumentInfo documentInfoForUpdate = getDocumentInfoByUserIdAndDocumentType(documentInfo.getUserId(), String.valueOf(documentInfo.getDocumentType()));
                update(documentInfoForUpdate);
                return DATA_EXISTS;
            }
        }
        catch (Exception ex){
            log.error("Error occurred inside @method saveDocumentInfo : {}",ex.getStackTrace());
            return SOMETHING_WENT_WRONG;
        }
    }

    @Override
    public List<DocumentInfo> getDocumentInfoByUserId(String userId) {
        log.info("Inside @Class DocumentInfoDaoImpl @Method getDocumentInfoByUserId : {}",userId);
        try {
            return entityManager
                    .createNamedQuery(Constants.GET_DOCUMENT_INFO_BY_USER_ID, DocumentInfo.class)
                    .setParameter("userId", userId)
                    .getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public DocumentInfo getDocumentInfoByUserIdAndDocumentType(String userId,String documentType) {
        log.info("Inside @Class DocumentInfoDaoImpl @Method getDocumentInfoByUserIdAndDocumentType : {}",userId);
        try {
            return entityManager
                    .createNamedQuery(Constants.GET_DOCUMENT_INFO_BY_USER_ID_AND_DOCUMENT_TYPE, DocumentInfo.class)
                    .setParameter("userId", userId)
                    .setParameter("documentType",documentType)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(DocumentInfo documentInfo) {
        entityManager.persist(documentInfo);
    }

    @Override
    public void update(DocumentInfo documentInfo) {
         entityManager.merge(documentInfo);
    }

    @Transactional
    @Override
    public String deleteDocumentByUserId(String userId,String documentType){
        log.info("Inside @Class AddressInfoDaoImpl @Method deleteAddressByUserId :{}",userId);
        try{
           DocumentInfo documentInfos = getDocumentInfoByUserIdAndDocumentType(userId,documentType);
            log.info("Address info : {}",documentInfos);
            if(Objects.nonNull(documentInfos)){
                DocumentInfo managedEntity =  entityManager.merge(documentInfos);
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

