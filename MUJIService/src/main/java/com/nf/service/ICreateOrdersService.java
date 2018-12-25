package com.nf.service;

import com.nf.entities.CreateOrders;

import java.util.List;
import java.util.Map;

public interface ICreateOrdersService {
    List<CreateOrders> selectCreateOrdersByPhone(Map<String,Object> objectMap);

    int initOneCreateOrders(Map<String,Object>objectMap);

    int updatePendingShipmentByCono(String cono);

    int updatePendingReceiptByCono(String cono);

    int updateCompletedByCono(String cono);

    int updateAfterSaleByCono(String cono);
}
