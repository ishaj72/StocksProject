package com.example.dao.interfaces;

import com.example.modules.AddressInfo;

public interface IAddressInfoDao {
    AddressInfo getAddressInfoByUserId(String userId);

    String saveAddressInfo(AddressInfo addressInfo);

    String deleteAddressByUserId(String userId);
}
