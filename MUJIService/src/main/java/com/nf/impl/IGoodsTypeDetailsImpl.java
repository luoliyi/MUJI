package com.nf.impl;

import com.nf.entities.GoodsType;
import com.nf.entities.GoodsTypeDetails;
import com.nf.interfaces.IGoodsTypeDao;
import com.nf.interfaces.IGoodsTypeDetailsDao;
import com.nf.service.IGoodsTypeDetailsService;
import com.nf.service.IGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
@Service
public class IGoodsTypeDetailsImpl implements IGoodsTypeDetailsService {

    @Autowired
    IGoodsTypeDetailsDao goodsTypeDetailsDao;

    @Override
    public List<GoodsTypeDetails> selectAllGoodsTypeDetailsByGtdid(Map<String, Object> objectMap) {
        return goodsTypeDetailsDao.selectAllGoodsTypeDetailsByGtdid(objectMap);
    }
}
