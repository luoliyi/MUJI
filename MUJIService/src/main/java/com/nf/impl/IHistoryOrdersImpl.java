package com.nf.impl;

import com.nf.entities.Administrator;
import com.nf.entities.HistoryOrdersDiary;
import com.nf.interfaces.IAdministratorDao;
import com.nf.interfaces.IHistoryOrdersDao;
import com.nf.service.IAdministratorService;
import com.nf.service.IHistoryOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Controller
@Service
public class IHistoryOrdersImpl implements IHistoryOrdersService {

    @Autowired
    IHistoryOrdersDao historyOrdersDao;


    @Override
    public int insert(Map<String, Object> objectMap) {
        return historyOrdersDao.insert(objectMap);
    }

    @Override
    public int delete(Map<String, Object> objectMap) {
        return historyOrdersDao.delete(objectMap);
    }

    @Override
    public int selectCount() {
        return historyOrdersDao.selectCount();
    }

    @Override
    public List<HistoryOrdersDiary> selectHistoryOrdersDiary(Map<String, Object> objectMap) {
        return historyOrdersDao.selectHistoryOrdersDiary(objectMap);
    }

    @Override
    public int selectHistoryOrdersDiaryCount() {
        return historyOrdersDao.selectHistoryOrdersDiaryCount();
    }

    @Override
    public int insertOrdersDiary(Map<String, Object> objectMap) {
        return historyOrdersDao.insertOrdersDiary(objectMap);
    }
}
