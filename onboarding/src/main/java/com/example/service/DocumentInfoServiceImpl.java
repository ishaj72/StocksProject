package com.example.service;

import com.example.constants.Constants;
import com.example.dao.interfaces.IDocumentInfoDao;
import com.example.modules.DocumentInfo;
import com.example.modules.OnboardInfo;
import com.example.service.interfaces.IDocumentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

import static com.example.constants.Constants.*;

@Service
@Slf4j
public class DocumentInfoServiceImpl implements IDocumentInfoService {

    @Autowired
    IDocumentInfoDao documentInfoDao;

    @Override
    public String saveDocumentInfo(DocumentInfo documentInfo){
        log.info("Inside @Class DocumentInfoServiceImpl @Method saveDocumentInfo for: {}",documentInfo);
        try{
           return documentInfoDao.saveDocumentInfo(documentInfo);
        }
        catch(Exception ex){
            log.error("Error occurred inside @method saveOnboardingInfo :{}",ex.getMessage());
            throw new RuntimeException(Constants.SOMETHING_WENT_WRONG);
        }

    }

    @Override
    public List<DocumentInfo> getDocumentInfoByUserId(String userId){
        log.info("Inside @Class DocumentInfoServiceImpl @Method getDocumentInfoByUserId for: {}",userId);
        try{
           return documentInfoDao.getDocumentInfoByUserId(userId);
        }
        catch(Exception ex){
            log.error("Error occurred inside @method getDocumentInfoByUserId :{}",ex.getMessage());
            throw new RuntimeException(Constants.SOMETHING_WENT_WRONG);
        }
    }
}
