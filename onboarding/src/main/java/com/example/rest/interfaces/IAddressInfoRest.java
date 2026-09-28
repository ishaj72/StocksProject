package com.example.rest.interfaces;

import com.example.modules.AddressInfo;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/address")
public interface IAddressInfoRest {

    @PostMapping("/saveAddressInfo")
    String saveAddressInfo(@RequestBody  AddressInfo addressInfo);

    @DeleteMapping("/deleteAddressByUserId")
    String deleteAddressByUserId(@RequestParam String userId);


}
