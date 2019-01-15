package com.nf.service;

import com.nf.entities.CreateOrders;

import java.util.List;
import java.util.Map;

public interface ICreateOrdersService {
    List<CreateOrders> selectCreateOrdersByPhone(Map<String, Object> objectMap);

    int initOneCreateOrders(Map<String, Object> objectMap);

    int updatePendingShipmentByCono(String cono);

    int updatePendingReceiptByCono(String cono);

    int updateCompletedByCono(String cono);

    int cancelOrders(String cono);

    int updateAfterSaleByCono(String cono);

    int selectSumPriceByCono(String cono);

    int ordersSuccessPay(String cono);

    String checkOrderPayStatus(String cono);

    List<CreateOrders> selectAllOrderByMphoneAndStateAndLimit(Map<String, Object> objectMap);

    List<CreateOrders> backgroundSelectAllOrders(Map<String, Object> objectMap);

    int backgroundUpdateConoStatus(Map<String, Object> objectMap);
}
