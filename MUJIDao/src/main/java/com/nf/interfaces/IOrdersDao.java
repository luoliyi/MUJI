package com.nf.interfaces;

import com.nf.entities.CreateOrders;
import com.nf.entities.Orders;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;

public interface IOrdersDao {
    List<Orders> selectAllOrderByMphoneAndState(Map<String,Object>objectMap);
    int insert(Map<String,Object>objectMap);
    int update(Map<String,Object>objectMap);
    int delete(Map<String,Object>objectMap);

    List<Orders>selectAllGoodsByCono(Map<String,Object>objectMap);

}
