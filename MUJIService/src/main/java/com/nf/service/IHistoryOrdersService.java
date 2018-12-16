package com.nf.service;

import com.nf.entities.Administrator;
import com.nf.entities.HistoryOrdersDiary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IHistoryOrdersService {
    int insert(Map<String,Object>objectMap);
    int delete(Map<String,Object>objectMap);
    int selectCount();
    List<HistoryOrdersDiary>selectHistoryOrdersDiary(Map<String,Object>objectMap);

    int selectHistoryOrdersDiaryCount();
    int insertOrdersDiary(Map<String,Object>objectMap);
}
