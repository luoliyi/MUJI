package com.nf.interfaces;

import com.nf.entities.HistoryOrdersDiary;

import java.util.List;
import java.util.Map;

public interface IHistoryOrdersDao {
    int insert(Map<String,Object>objectMap);
    int delete(Map<String,Object>objectMap);

    int selectCount();

    List<HistoryOrdersDiary>selectHistoryOrdersDiary(Map<String,Object>objectMap);

    int selectHistoryOrdersDiaryCount();

    int insertOrdersDiary(Map<String,Object>objectMap);

}
