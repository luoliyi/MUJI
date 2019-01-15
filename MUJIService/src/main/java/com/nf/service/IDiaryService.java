package com.nf.service;

import com.nf.entities.Administrator;
import com.nf.entities.Diary;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface IDiaryService {
    List<Diary> selectAllDiary(Map<String, Object> objectMap);

    int delete(Map<String, Object> objectMap);

    int update(Map<String, Object> objectMap);

    int insert(Map<String, Object> objectMap);
}
