package com.nf.dao.test;

import com.nf.entities.Goods;
import com.nf.interfaces.IGoodsDao;
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
public class IGoodsDaoTest {

    @Autowired
    IGoodsDao goodsDao;

    @Test
    public void queryAllGoods() {

        Map<String, Object> objectMap = new HashMap<>();

        objectMap.put("gname", "");
        objectMap.put("gcolor", "");
        objectMap.put("gsize", "");
        objectMap.put("startprice", 0);
        objectMap.put("endprice", 9999);
        objectMap.put("gtdid", "");
        objectMap.put("tid", "");
        objectMap.put("gdesc", "");
        objectMap.put("gpic", "");
        objectMap.put("gno", "");
        objectMap.put("gstate", "1");
        objectMap.put("gid", "");
        objectMap.put("pageno", 0);
        objectMap.put("pagesize", 9999);

        List<Goods> goodsList = goodsDao.selectAllGoods(objectMap);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }

    @Test
    public void delete() {
        int r = goodsDao.delete("4550002036508");
        System.out.println("result:" + r);
    }

    @Test
    public void update() {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("gname", "番石榴");
        objectMap.put("gcolor", "绿色");
        objectMap.put("gsize", "");
        objectMap.put("gnowprice", "12");
        objectMap.put("gtdid ", "1");
        objectMap.put("tid", "1");
        objectMap.put("gdesc", "卖完啦");
        objectMap.put("gpic", "12.jpg");
        objectMap.put("gstate", "0");
        objectMap.put("gno", "7864880333688");
        objectMap.put("gid", "12");

        int result = goodsDao.update(objectMap);
        System.out.println(result);
    }
}
