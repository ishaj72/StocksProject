package com.example.rest;

import com.example.modules.DocumentInfo;
import com.example.rest.interfaces.IAddressInfoRest;
import com.example.rest.interfaces.IDocumentInfoRest;
import com.example.service.interfaces.IDocumentInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DocumentInfoRestImpl implements IDocumentInfoRest {

    @Autowired
    IDocumentInfoService documentInfoService;

    @Override
    public String saveDocumentInfo(DocumentInfo documentInfo){
        log.info("Inside @Class DocumentInfoRestImpl @Method saveDocumentInfo for :{}",documentInfo);
        return documentInfoService.saveDocumentInfo(documentInfo);
    }

    @Override
    public List<DocumentInfo> getDocumentInfoByUserId(@RequestParam String userId){
        log.info("Inside @Class DocumentInfoRestImpl @Method getDocumentInfoByUserId for :{}",userId);
        return  documentInfoService.getDocumentInfoByUserId(userId);
    }

    @Override
    public void deleteDocumentInfoByUserId(@RequestParam String userId){
        log.info("Inside @Class DocumentInfoRestImpl @Method deleteDocumentInfoByUserId for :{}",userId);

    }

}
