package com.nf.impl;

import com.nf.entities.Goods;
import com.nf.interfaces.IGoodsDao;
import com.nf.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
@Service
public class IGoodsImpl implements IGoodsService {

    @Autowired
    IGoodsDao goodsDao;

    @Override
    public List<Goods> selectAllGoods(Map<String,Object> objectMap) {
        return goodsDao.selectAllGoods(objectMap);
    }

    @Override
    public int insert(Map<String, Object> objectMap) {
        return goodsDao.insert(objectMap);
    }


    @Override
    public int update(Map<String, Object> objectMap) {
        return goodsDao.update(objectMap);
    }

    @Override
    public int delete(String goodNo) {
        return goodsDao.delete(goodNo);
    }
}
