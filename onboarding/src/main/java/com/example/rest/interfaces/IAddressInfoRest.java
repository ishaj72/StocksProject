package com.example.rest.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface IAddressInfoRest {

    @PostMapping("api/v1/address")
    void saveAddressInfo(String userId);
}
