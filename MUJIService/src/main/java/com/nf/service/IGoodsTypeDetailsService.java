package com.nf.service;

import com.nf.entities.GoodsType;
import com.nf.entities.GoodsTypeDetails;

import java.util.List;
import java.util.Map;

public interface IGoodsTypeDetailsService {
    List<GoodsTypeDetails> selectAllGoodsTypeDetailsByGtdid(Map<String, Object> objectMap);
}
