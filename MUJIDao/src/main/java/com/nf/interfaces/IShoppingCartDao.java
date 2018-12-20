package com.nf.interfaces;

import com.nf.entities.ShoppingCart;

import java.util.List;
import java.util.Map;

public interface IShoppingCartDao {

    List<ShoppingCart>selectAllCartByMphone(Map<String ,Object>objectMap);

    int insert(Map<String ,Object>objectMap);
    int update(Map<String ,Object>objectMap);
    int delete(Map<String ,Object>objectMap);

    int delCount(Map<String,Object>objectMap);
    int addCount(Map<String,Object>objectMap);
}
