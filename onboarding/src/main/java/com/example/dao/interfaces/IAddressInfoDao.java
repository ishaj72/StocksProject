package com.example.dao.interfaces;

import com.example.modules.AddressInfo;

public interface IAddressInfoDao {
    AddressInfo getAddressInfoById();

    String saveAddressInfo(AddressInfo addressInfo);
}
