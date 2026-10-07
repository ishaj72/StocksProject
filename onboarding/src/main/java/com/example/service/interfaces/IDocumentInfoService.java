package com.example.service.interfaces;

import com.example.modules.DocumentInfo;

import java.util.List;

public interface IDocumentInfoService {

    String saveDocumentInfo(DocumentInfo documentInfo);

    List<DocumentInfo> getDocumentInfoByUserId(String userId);

}
