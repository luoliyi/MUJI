package com.nf.interfaces;

import com.nf.entities.Goods;
import com.nf.entities.PictureList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IPictureListDao {

    List<PictureList> selectAllPicture(@Param("gid") String gid);

    List<Goods> selectAllGoods();

    int insert(Map<String, Object> objectMap);

    int update(Map<String, Object> MemberList);

    int delete(Map<String, Object> objectMap);

    PictureList selectOnePicture(@Param("picid") String picid);

}
