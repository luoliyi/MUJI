package com.nf.dao.test;

import com.nf.entities.Goods;
import com.nf.entities.GoodsType;
import com.nf.entities.GoodsTypeDetails;
import com.nf.interfaces.IGoodsDao;
import com.nf.interfaces.IGoodsTypeDao;
import com.nf.interfaces.IGoodsTypeDetailsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ContextConfiguration({"classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@Rollback()  //是否回滚
public class IGoodsTypeDaoTest {

    @Autowired
    IGoodsTypeDao goodsTypeDao;

    @Autowired
    IGoodsTypeDetailsDao goodsTypeDetailsDao;

    @Test
    public void selectAllGoodsTypeDetailsByTid(){

        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("tid",1);
        List<GoodsType>goodsTypes=goodsTypeDao.selectAllGoodsTypeDetailsByTid(objectMap);
        System.out.println(goodsTypes);

    }

    @Test
    public void selectAllGoodsTypeDetailsByGtdid() {
        Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("gtdid",12);
        List<GoodsTypeDetails>goodsTypeDetails=goodsTypeDetailsDao.selectAllGoodsTypeDetailsByGtdid(objectMap);
        System.out.println(goodsTypeDetails);
    }

}
