package com.nf.impl;

import com.nf.entities.ShoppingCart;
import com.nf.interfaces.IShoppingCartDao;
import com.nf.service.IShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Controller
@Service
public class IShoppingCartImpl implements IShoppingCartService {

    @Autowired
    IShoppingCartDao shoppingCartDao;

    @Override
    public List<ShoppingCart> selectAllCartByMphone(Map<String, Object> objectMap) {
        return shoppingCartDao.selectAllCartByMphone(objectMap);
    }

    @Override
    public int insert(Map<String, Object> objectMap) {
        return shoppingCartDao.insert(objectMap);
    }

    @Override
    public int update(Map<String, Object> objectMap) {
        return shoppingCartDao.update(objectMap);
    }

    @Override
    public int delete(Map<String, Object> objectMap) {
        return shoppingCartDao.delete(objectMap);
    }

    @Override
    public int delCount(Map<String, Object> objectMap) {
        return shoppingCartDao.delCount(objectMap);
    }

    @Override
    public int addCount(Map<String, Object> objectMap) {
        return shoppingCartDao.addCount(objectMap);
    }
}
