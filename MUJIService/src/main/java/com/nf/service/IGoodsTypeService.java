package com.nf.service;

import com.nf.entities.GoodsType;

import java.util.List;
import java.util.Map;

public interface IGoodsTypeService {
    List<GoodsType> selectAllGoodsTypeDetailsByTid(Map<String,Object>objectMap);
}
