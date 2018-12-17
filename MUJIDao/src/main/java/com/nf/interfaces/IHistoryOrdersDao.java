package com.nf.interfaces;

import com.nf.entities.HistoryOrdersDiary;

import java.util.List;
import java.util.Map;

public interface IHistoryOrdersDao {
    int insert(Map<String,Object>objectMap);
    int delete();

    int selectCount();

    List<HistoryOrdersDiary>selectHistoryOrdersDiary(Map<String,Object>objectMap);

    int selectHistoryOrdersDiaryCount();

    int insertOrdersDiary(Map<String,Object>objectMap);

}
