package com.nf.service;

import com.nf.entities.DaySales;
import com.nf.entities.Sales;

import java.util.List;
import java.util.Map;

public interface ISalesService {
    List<Sales> selectAllSalesVolume(Map<String,Object> objectMap);

    List<DaySales>selectOneDaySalesVolume(Map<String,Object>objectMap);
}
