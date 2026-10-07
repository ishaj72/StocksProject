package com.example.dao.interfaces;

import com.example.modules.DocumentInfo;
import com.example.modules.OnboardInfo;

import java.util.List;

public interface IDocumentInfoDao {

    public String saveDocumentInfo(DocumentInfo documentInfo);

    public List<DocumentInfo> getDocumentInfoByUserId(String userId);

    public void update(DocumentInfo documentInfo);

    public void save(DocumentInfo documentInfo);

    public DocumentInfo getDocumentInfoByUserIdAndDocumentType(String userId,String documentType);

    public String deleteDocumentByUserId(String userId,String documentType);
}
