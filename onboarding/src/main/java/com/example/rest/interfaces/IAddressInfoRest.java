package com.example.rest.interfaces;

import com.example.modules.AddressInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface IAddressInfoRest {

    @PostMapping("api/v1/saveAddressInfo")
    String saveAddressInfo(AddressInfo addressInfo);
}
