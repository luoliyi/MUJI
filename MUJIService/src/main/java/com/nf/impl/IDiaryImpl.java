package com.nf.impl;

import com.nf.entities.Diary;
import com.nf.interfaces.IDiaryDao;
import com.nf.service.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Controller
@Service
public class IDiaryImpl implements IDiaryService {

    @Autowired
    IDiaryDao diaryDao;


    @Override
    public List<Diary> selectAllDiary(Map<String, Object> objectMap) {
        return diaryDao.selectAllDiary(objectMap);
    }

    @Override
    public int delete(Map<String, Object> objectMap) {
        return diaryDao.delete(objectMap);
    }

    @Override
    public int update(Map<String, Object> objectMap) {
        return diaryDao.update(objectMap);
    }

    @Override
    public int insert(Map<String, Object> objectMap) {
        return diaryDao.insert(objectMap);
    }
}
