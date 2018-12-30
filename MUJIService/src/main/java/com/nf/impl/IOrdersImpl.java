package com.nf.impl;

import com.nf.entities.Orders;
import com.nf.interfaces.IOrdersDao;
import com.nf.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;

@Service
public class IOrdersImpl implements IOrdersService {

    @Autowired
    IOrdersDao ordersDao;


    @Override
    public List<Orders> selectAllOrderByMphoneAndState(Map<String, Object> objectMap) {
        return ordersDao.selectAllOrderByMphoneAndState(objectMap);
    }

    @Override
    public int insert(Map<String, Object> objectMap) {
        return ordersDao.insert(objectMap);
    }

    @Override
    public int update(Map<String, Object> objectMap) {
        return ordersDao.update(objectMap);
    }

    @Override
    public int delete(Map<String, Object> objectMap) {
        return ordersDao.delete(objectMap);
    }

    @Override
    public List<Orders> selectAllGoodsByCono(Map<String, Object> objectMap) {
        return ordersDao.selectAllGoodsByCono(objectMap);
    }
}
