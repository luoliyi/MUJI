package com.nf.impl;

import com.nf.entities.GoodsType;
import com.nf.interfaces.IGoodsTypeDao;
import com.nf.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
@Service
public class IGoodsTypeImpl implements IGoodsTypeService {

    @Autowired
    IGoodsTypeDao goodsTypeDao;

    @Override
    public List<GoodsType> selectAllGoodsTypeDetailsByTid(Map<String, Object> objectMap) {
        return goodsTypeDao.selectAllGoodsTypeDetailsByTid(objectMap);
    }
}
