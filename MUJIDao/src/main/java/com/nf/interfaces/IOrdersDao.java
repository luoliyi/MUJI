package com.nf.interfaces;

import com.nf.entities.CreateOrders;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;

public interface IOrdersDao {
    List<Order> selectAllOrderByMphoneAndState(Map<String,Object>objectMap);
    int insert(Map<String,Object>objectMap);
    int update(Map<String,Object>objectMap);
    int delete(Map<String,Object>objectMap);
}
