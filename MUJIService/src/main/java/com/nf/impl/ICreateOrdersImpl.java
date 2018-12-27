package com.nf.impl;

import com.nf.entities.CreateOrders;
import com.nf.interfaces.ICreateOrdersDao;
import com.nf.service.ICreateOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ICreateOrdersImpl implements ICreateOrdersService {

    @Autowired
    ICreateOrdersDao ordersDao;

    @Override
    public List<CreateOrders> selectCreateOrdersByPhone(Map<String, Object> objectMap) {
        return ordersDao.selectCreateOrdersByPhone(objectMap);
    }

    @Override
    public int initOneCreateOrders(Map<String, Object> objectMap) {
        return ordersDao.initOneCreateOrders(objectMap);
    }

    @Override
    public int updatePendingShipmentByCono(String cono) {
        return ordersDao.updatePendingShipmentByCono(cono);
    }

    @Override
    public int updatePendingReceiptByCono(String cono) {
        return ordersDao.updatePendingReceiptByCono(cono);
    }

    @Override
    public int updateCompletedByCono(String cono) {
        return ordersDao.updateCompletedByCono(cono);
    }

    @Override
    public int updateAfterSaleByCono(String cono) {
        return ordersDao.updateAfterSaleByCono(cono);
    }

    @Override
    public List<CreateOrders> selectAllOrderByMphoneAndStateAndLimit(Map<String, Object> objectMap) {
        return ordersDao.selectAllOrderByMphoneAndStateAndLimit(objectMap);
    }
}
