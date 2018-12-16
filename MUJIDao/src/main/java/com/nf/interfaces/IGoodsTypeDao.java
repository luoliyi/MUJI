package com.nf.interfaces;

import com.nf.entities.GoodsType;
import com.nf.entities.GoodsTypeDetails;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IGoodsTypeDao {

  List<GoodsType> selectAllGoodsTypeDetailsByTid(Map<String,Object>objectMap);


}
