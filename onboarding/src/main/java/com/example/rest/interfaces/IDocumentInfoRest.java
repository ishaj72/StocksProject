package com.example.rest.interfaces;

import com.example.modules.DocumentInfo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/document")
public interface IDocumentInfoRest {

    @PostMapping("/saveDocumentInfo")
    String saveDocumentInfo(@RequestBody DocumentInfo documentInfo);

    @GetMapping("/getDocumentInfoByUserId")
    List<DocumentInfo> getDocumentInfoByUserId(@RequestParam String userId);

    @DeleteMapping("/deleteDocumentInfoByUserId")
    void deleteDocumentInfoByUserId(@RequestParam String userId);

}
