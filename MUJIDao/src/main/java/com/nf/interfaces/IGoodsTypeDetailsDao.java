package com.nf.interfaces;

import com.nf.entities.GoodsType;
import com.nf.entities.GoodsTypeDetails;

import java.util.List;
import java.util.Map;

public interface IGoodsTypeDetailsDao {

  List<GoodsTypeDetails> selectAllGoodsTypeDetailsByGtdid(Map<String, Object> objectMap);

}
