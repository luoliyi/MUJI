package com.nf.impl;

import com.nf.entities.Administrator;
import com.nf.entities.PictureList;
import com.nf.interfaces.IAdministratorDao;
import com.nf.service.IAdministratorService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Controller
@Service
public class IAdministratorImpl implements IAdministratorService {

    @Autowired
    IAdministratorDao administratorDao;

    @Override
    public List<Administrator> selectAllAdministrator(Map<String, Object> objectMap) {
        return administratorDao.selectAllAdministrator(objectMap);
    }

    @Override
    public int insert(Map<String, Object> objectMap) {
        return administratorDao.insert(objectMap);
    }

    @Override
    public int update(Map<String, Object> objectMap) {
        return administratorDao.update(objectMap);
    }

    @Override
    public int delete(String aid) {
        return administratorDao.delete(aid);
    }

    @Override
    public Administrator selectOneAdministrator(String aid) {
        return administratorDao.selectOneAdministrator(aid);
    }
}
