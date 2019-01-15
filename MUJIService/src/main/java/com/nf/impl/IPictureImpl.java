package com.nf.impl;

import com.nf.entities.Goods;
import com.nf.entities.PictureList;
import com.nf.interfaces.IPictureListDao;
import com.nf.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Controller
@Service
public class IPictureImpl implements IPictureService {

    @Autowired
    IPictureListDao pictureListDao;


    @Override
    public List<PictureList> selectAllPicture(String gid) {
        return pictureListDao.selectAllPicture(gid);
    }

    @Override
    public int insert(Map<String, Object> objectMap) {
        return pictureListDao.insert(objectMap);
    }

    @Override
    public int update(Map<String, Object> MemberList) {
        return pictureListDao.update(MemberList);
    }


    @Override
    public int delete(Map<String, Object> objectMap) {
        return pictureListDao.delete(objectMap);
    }

    @Override
    public List<Goods> selectAllGoods() {
        return pictureListDao.selectAllGoods();
    }

    @Override
    public PictureList selectOnePicture(String picid) {
        return pictureListDao.selectOnePicture(picid);
    }
}
