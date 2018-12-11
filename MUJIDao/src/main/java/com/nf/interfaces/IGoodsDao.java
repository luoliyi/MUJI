package com.nf.interfaces;

import com.nf.entities.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IGoodsDao {

    List<Goods>selectAllGoods(Map<String,Object> goodsLimitMap);

    int insert(Map<String,Object> objectMap);

    int update(Map<String,Object> objectMap);

    int delete(@Param("goodno") String goodno);

    List<Goods>selectNewGoods(Map<String,Object> goodsLimitMap);

    Goods selectOneGood(int gid);


}
